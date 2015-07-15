package controllers

import models.Cat
import java.io.File
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import anorm._
import views._
import models._

import play.api.i18n._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import java.io.ByteArrayInputStream




/**
 * Manage a database of cats
 */
object Application extends Controller { 
  
  /**
   * This result directly redirect to the application home.
   */
  val Home = Redirect(routes.Application.list(0, 2, ""))
  
  /**
   * Describe the cat form (used in both edit and create screens).
   */ 
  val catForm = Form(
    mapping(
      "id" -> ignored(NotAssigned:Pk[Long]),
      "name" -> nonEmptyText,
      "gender" -> nonEmptyText,
      "color" -> nonEmptyText,
      "birth" -> optional(date("yyyy-MM-dd")),
      "race" -> optional(longNumber)
    )(Cat.apply)(Cat.unapply)

  
  )


  // -- Actions

/** 
 * Handle file upload 
 */
  def upload(name: String) = Action(parse.multipartFormData) { request =>
  request.body.file("picture").map { picture =>
    import java.io.File
    val filename = picture.filename 
    val contentType = picture.contentType
    picture.ref.moveTo(new File("public/images/" + name +".jpg"),true)
    Redirect(routes.Application.list(0, 2, ""))
  }.getOrElse {
    Redirect(routes.Application.list(0, 2, "")).flashing(
      "error" -> "Missing file"
    )
  }
}

/* Pick a picture from public/images   */

def pickPict(name: String) = Action {
def path = "public/images/" + name + ".jpg"
Ok.sendFile(new java.io.File(path))
}

/* Delete a picture from public/images */

def deletePict(name: String){
val file: File = new File("public/images/" + name + ".jpg")
file.delete()
}


  /**
   * Handle default path requests, redirect to cats list
   */  
  def index = Action { Home }
  
  /**
   * Display the paginated list of cats.
   *
   * @param page Current page number (starts from 0)
   * @param orderBy Column to be sorted
   * @param filter Filter applied on cat names
   */
  def list(page: Int, orderBy: Int, filter: String) = Action { implicit request =>
    Ok(html.list(
      Cat.list(page = page, orderBy = orderBy, filter = ("%"+filter+"%")),
      orderBy, filter
    ))
  }
  
  /**
   * Display the 'edit form' of a existing Cat.
   *
   * @param id Id of the cat to edit
   */
  def edit(id: Long,name:String) = Action {
    Cat.findById(id).map { cat =>
      Ok(html.editForm(id,name,catForm.fill(cat)))
    }.getOrElse(NotFound)
  }
  
  /**
   * Handle the 'edit form' submission 
   *
   * @param id Id of the cat to edit
   */
  def update(id: Long,name:String) = Action { implicit request =>
    catForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.editForm(id,name,formWithErrors)),
      cat => {
        Cat.update(id, cat)
        Home.flashing("success" -> "Cat %s has been updated".format(cat.name))
      }
    )
  }
  
  /**
   * Display the 'new cat form'.
   */
  def create = Action {
    Ok(html.createForm(catForm))
  }
  
  /**
   * Handle the 'new cat form' submission.
   */
  def save = Action { implicit request =>
    catForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.createForm(formWithErrors)),
      cat => {
        Cat.insert(cat)
        Home.flashing("success" -> "Cat %s has been created".format(cat.name))
      }
    )
  }
  
  /**
   * Handle cat delete, the entry and the corresponding picture.
   */
  def delete(id: Long,name:String) = Action {
    Cat.delete(id)
    deletePict(name)
    Home.flashing("success" -> "Cat has been deleted")
  }

}
            