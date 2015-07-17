
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

                  	    
        </fieldset>
        
        <div class="actions">
             <input type="submit" value="Save this cat" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*39.23*/routes/*39.29*/.Application.list())),format.raw/*39.48*/("""" class="btn">Cancel</a> 
        </div>

	""")))})),format.raw/*42.3*/("""
	
     
   <a href=""""),_display_(Seq(/*45.14*/routes/*45.20*/.Application.delete(id))),format.raw/*45.43*/("""" 
   class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete this cat</a>
	
	
""")))})),format.raw/*49.2*/("""
"""))}
    }
    
    def render(id:Long,catForm:Form[Cat]) = apply(id,catForm)
    
    def f:((Long,Form[Cat]) => play.api.templates.Html) = (id,catForm) => apply(id,catForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 17 02:19:35 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/test/app/views/editForm.scala.html
                    HASH: 671be9bfe3d9c86944d2b0ac26789b50399013df
                    MATRIX: 516->1|630->51|662->75|736->30|764->49|792->124|824->127|835->131|868->133|936->171|1014->240|1049->242|1124->286|1197->337|1232->342|1452->540|1510->567|1579->614|1624->628|1697->679|1755->706|1979->908|2198->1096|2213->1102|2254->1121|2329->1165|2382->1187|2397->1193|2442->1216|2570->1313
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|37->16|37->16|38->17|43->22|45->24|45->24|46->25|46->25|48->27|53->32|60->39|60->39|60->39|63->42|66->45|66->45|66->45|70->49
                    -- GENERATED --
                */
            