
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,String,Form[Cat],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,name:String ,catForm: Form[Cat]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq(format.raw/*1.44*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Edit cat</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.update(id,name),'enctype -> "multipart/form-data")/*11.80*/ {_display_(Seq(format.raw/*11.82*/("""
        
        <fieldset>
        
          """),_display_(Seq(/*15.12*/inputText(catForm("name"), '_label -> "Cat's name"))),format.raw/*15.63*/("""
	  """),_display_(Seq(/*16.5*/select(
                catForm("gender"), 
                options = options(Genders.list),
                '_default -> "--- Choose a Gender ---",
                '_label -> "Gender"
            ))),format.raw/*21.14*/("""
            
            """),_display_(Seq(/*23.14*/inputText(catForm("color"), '_label -> "Color"))),format.raw/*23.61*/("""
            """),_display_(Seq(/*24.14*/inputText(catForm("birth"), '_label -> "Birthdate"))),format.raw/*24.65*/("""
            
            """),_display_(Seq(/*26.14*/select(
                catForm("race"), 
                Race.options, 
                '_label -> "Breed", '_default -> "-- Choose a breed --",
                '_showConstraints -> false
            ))),format.raw/*31.14*/("""

                  	    
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save this cat" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*38.23*/routes/*38.29*/.Application.list())),format.raw/*38.48*/("""" class="btn">Cancel</a> 
        </div>

	""")))})),format.raw/*41.3*/("""
	
     
   <a href=""""),_display_(Seq(/*44.14*/routes/*44.20*/.Application.delete(id,name))),format.raw/*44.48*/("""" 
   class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete this cat</a>
	
	
""")))})),format.raw/*48.2*/("""
"""))}
    }
    
    def render(id:Long,name:String,catForm:Form[Cat]) = apply(id,name,catForm)
    
    def f:((Long,String,Form[Cat]) => play.api.templates.Html) = (id,name,catForm) => apply(id,name,catForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 16 00:18:09 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/test/app/views/editForm.scala.html
                    HASH: 1a79fc6c057cc032fb61dd5c66ae58826c2f26d0
                    MATRIX: 523->1|650->64|682->88|756->43|784->62|812->137|844->140|855->144|888->146|956->184|1039->258|1074->260|1154->309|1227->360|1262->365|1482->563|1540->590|1609->637|1654->651|1727->702|1785->729|2009->931|2227->1118|2242->1124|2283->1143|2358->1187|2411->1209|2426->1215|2476->1243|2604->1340
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|42->21|44->23|44->23|45->24|45->24|47->26|52->31|59->38|59->38|59->38|62->41|65->44|65->44|65->44|69->48
                    -- GENERATED --
                */
            