
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Long,Form[Cat],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,cattag: Long,catForm: Form[Cat]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq(format.raw/*1.44*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Edit cat</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.update(id,cattag),'enctype -> "multipart/form-data")/*11.82*/ {_display_(Seq(format.raw/*11.84*/("""
        
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

        <input type="hidden" name="cattag" value="cattag" />
   
        </fieldset>
        
        <div class="actions">
             <input type="submit" value="Save this cat" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*40.23*/routes/*40.29*/.Application.list())),format.raw/*40.48*/("""" class="btn">Cancel</a> 
        </div>

	""")))})),format.raw/*43.3*/("""


     
   <a href=""""),_display_(Seq(/*47.14*/routes/*47.20*/.Application.delete(id))),format.raw/*47.43*/("""" 
   class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete this cat</a>
	
	
""")))})),format.raw/*51.2*/("""
"""))}
    }
    
    def render(id:Long,cattag:Long,catForm:Form[Cat]) = apply(id,cattag,catForm)
    
    def f:((Long,Long,Form[Cat]) => play.api.templates.Html) = (id,cattag,catForm) => apply(id,cattag,catForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jul 19 20:49:46 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/cdb2-tmp6/app/views/editForm.scala.html
                    HASH: 37b8e47265d2dfc9b2a7efe52119fdf29ca375f8
                    MATRIX: 521->1|648->64|680->88|754->43|782->62|810->137|842->140|853->144|886->146|954->184|1039->260|1074->262|1149->306|1222->357|1257->362|1477->560|1535->587|1604->634|1649->648|1722->699|1780->726|2004->928|2264->1157|2279->1163|2320->1182|2395->1226|2448->1248|2463->1254|2508->1277|2636->1374
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|37->16|37->16|38->17|43->22|45->24|45->24|46->25|46->25|48->27|53->32|61->40|61->40|61->40|64->43|68->47|68->47|68->47|72->51
                    -- GENERATED --
                */
            