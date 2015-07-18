
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Cat],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,catForm: Form[Cat]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq(format.raw/*1.31*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Edit cat</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.update(id),'enctype -> "multipart/form-data")/*11.75*/ {_display_(Seq(format.raw/*11.77*/("""
        
        <fieldset>

	 
          """),_display_(Seq(/*16.12*/inputText(catForm("name"), '_label -> "Cat's name"))),format.raw/*16.63*/("""
	  """),_display_(Seq(/*17.5*/select(
                catForm("gender"), 
                options = options(Genders.list),
                '_default -> "--- Choose a Gender ---",
                '_label -> "Gender"
            ))),format.raw/*22.14*/("""
            
            """),_display_(Seq(/*24.14*/inputText(catForm("color"), '_label -> "Color"))),format.raw/*24.61*/("""
            """),_display_(Seq(/*25.14*/inputText(catForm("birth"), '_label -> "Birthdate"))),format.raw/*25.65*/("""
            
            """),_display_(Seq(/*27.14*/select(
                catForm("race"), 
                Race.options, 
                '_label -> "Breed", '_default -> "-- Choose a breed --",
                '_showConstraints -> false
            ))),format.raw/*32.14*/("""

        <input type="hidden" name="cattag" value=""""),_display_(Seq(/*34.52*/controllers/*34.63*/.Application.rndInt(1000))),format.raw/*34.88*/("""" />
          
        </fieldset>
        
        <div class="actions">
             <input type="submit" value="Save this cat" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*40.23*/routes/*40.29*/.Application.list())),format.raw/*40.48*/("""" class="btn">Cancel</a> 
        </div>

	""")))})),format.raw/*43.3*/("""
	
     
   <a href=""""),_display_(Seq(/*46.14*/routes/*46.20*/.Application.delete(id))),format.raw/*46.43*/("""" 
   class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete this cat</a>
	
	
""")))})),format.raw/*50.2*/("""
"""))}
    }
    
    def render(id:Long,catForm:Form[Cat]) = apply(id,catForm)
    
    def f:((Long,Form[Cat]) => play.api.templates.Html) = (id,catForm) => apply(id,catForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 18 23:34:57 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/test/app/views/editForm.scala.html
                    HASH: 9f51005dd1c27bd1ca4b4c5410d8305cd4cb6ca3
                    MATRIX: 516->1|630->51|662->75|736->30|764->49|792->124|824->127|835->131|868->133|936->171|1014->240|1049->242|1124->286|1197->337|1232->342|1452->540|1510->567|1579->614|1624->628|1697->679|1755->706|1979->908|2063->961|2083->972|2130->997|2339->1175|2354->1181|2395->1200|2470->1244|2523->1266|2538->1272|2583->1295|2711->1392
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|37->16|37->16|38->17|43->22|45->24|45->24|46->25|46->25|48->27|53->32|55->34|55->34|55->34|61->40|61->40|61->40|64->43|67->46|67->46|67->46|71->50
                    -- GENERATED --
                */
            