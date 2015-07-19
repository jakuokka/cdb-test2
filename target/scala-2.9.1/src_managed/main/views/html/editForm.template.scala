
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Long,String,Long,Form[Cat],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long, curname: String, cattag: Long,catForm: Form[Cat]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq(format.raw/*1.62*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Edit cat</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.update(id,curname,cattag),'enctype -> "multipart/form-data")/*11.90*/ {_display_(Seq(format.raw/*11.92*/("""
        
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
    
    def render(id:Long,curname:String,cattag:Long,catForm:Form[Cat]) = apply(id,curname,cattag,catForm)
    
    def f:((Long,String,Long,Form[Cat]) => play.api.templates.Html) = (id,curname,cattag,catForm) => apply(id,curname,cattag,catForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jul 20 00:07:16 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/cdb2-tmp6/app/views/editForm.scala.html
                    HASH: 4e81ab128e9f959aa595a9fb30b870cfc4895974
                    MATRIX: 528->1|673->82|705->106|779->61|807->80|835->155|867->158|878->162|911->164|979->202|1072->286|1107->288|1182->332|1255->383|1290->388|1510->586|1568->613|1637->660|1682->674|1755->725|1813->752|2037->954|2297->1183|2312->1189|2353->1208|2428->1252|2481->1274|2496->1280|2541->1303|2669->1400
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|37->16|37->16|38->17|43->22|45->24|45->24|46->25|46->25|48->27|53->32|61->40|61->40|61->40|64->43|68->47|68->47|68->47|72->51
                    -- GENERATED --
                */
            