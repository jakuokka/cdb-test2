package models

import java.util.{Date}

import play.api.db._
import play.api.Play.current

import java.io.File
import anorm._
import anorm.SqlParser._

case class Race(id: Pk[Long] = NotAssigned, name: String)
case class Cat(id: Pk[Long] = NotAssigned, name: String, gender: String, color: String, birth: Option[Date], raceId: Option[Long])

/**
 * Helper for pagination.
 */
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

object Cat {
  
  // -- Parsers
  
  /**
   * Parse a Cat from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("cat.id") ~
    get[String]("cat.name") ~
    get[String]("cat.gender") ~
    get[String]("cat.color") ~
    get[Option[Date]]("cat.birth") ~
    get[Option[Long]]("cat.race_id") map {
      case id~name~gender~color~birth~raceId => Cat(id, name, gender,color, birth, raceId)
    }
  }
  
  /**
   * Parse a (Cat,Race) from a ResultSet
   */
  val withRace = Cat.simple ~ (Race.simple ?) map {
    case cat~race => (cat,race)
  }
  
  // -- Queries
  
  /**
   * Retrieve a cat from the id.
   */
  def findById(id: Long): Option[Cat] = {
    DB.withConnection { implicit connection =>
      SQL("select * from cat where id = {id}").on('id -> id).as(Cat.simple.singleOpt)
    }
  }
  
  /**
   * Return a page of (Cat,Race).
   *
   * @param page Page to display
   * @param pageSize Number of cats per page
   * @param orderBy Cat property used for sorting
   * @param filter Filter applied on the name column
   */
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Page[(Cat, Option[Race])] = {
    
    val offest = pageSize * page
    
    DB.withConnection { implicit connection =>
      
      val cats = SQL(
        """
          select * from cat 
          left join race on cat.race_id = race.id
          where cat.name like {filter}
          order by {orderBy} nulls last
          limit {pageSize} offset {offset}
        """
      ).on(
        'pageSize -> pageSize, 
        'offset -> offest,
        'filter -> filter,
        'orderBy -> orderBy
      ).as(Cat.withRace *)

      val totalRows = SQL(
        """
          select count(*) from cat 
          left join race on cat.race_id = race.id
          where cat.name like {filter}
        """
      ).on(
        'filter -> filter
      ).as(scalar[Long].single)

      Page(cats, page, offest, totalRows)
      
    }
    
  }
  
  /**
   * Update a cat.
   *
   * @param id The cat id
   * @param cat The cat values.
   */
  def update(id: Long, cat: Cat) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          update cat
          set name = {name}, gender = {gender},color={color}, birth = {birth}, race_id = {race_id}
          where id = {id}
        """
      ).on(
        'id -> id,
        'name -> cat.name,
        'gender -> cat.gender,
	'color -> cat.color,
        'birth -> cat.birth,
        'race_id -> cat.raceId
      ).executeUpdate()
    }
  }
  
  /**
   * Insert a new cat.
   *
   * @param cat The cat values.
   */
  def insert(cat: Cat) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into cat values (
            (select next value for cat_seq), 
            {name}, {gender},{color}, {birth}, {race_id}
          )
        """
      ).on(
        'name -> cat.name,
        'gender -> cat.gender,
	'color -> cat.color,
        'birth -> cat.birth,
        'race_id -> cat.raceId
      ).executeUpdate()
    }
  }
  
  /**
   * Delete a cat.
   *
   * @param id Id of the cat to delete.
   */
  def delete(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL("delete from cat where id = {id}").on('id -> id).executeUpdate()
    }
  }
  
}

object Race {
    
  /**
   * Parse a Race from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("race.id") ~
    get[String]("race.name") map {
      case id~name => Race(id, name)
    }
  }
  
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options: Seq[(String,String)] = DB.withConnection { implicit connection =>
    SQL("select * from race order by name").as(Race.simple *).map(c => c.id.toString -> c.name)
  }





}

