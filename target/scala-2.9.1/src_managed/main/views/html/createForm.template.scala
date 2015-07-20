
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Cat],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(catForm: Form[Cat]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq(format.raw/*1.22*/("""


"""),format.raw/*5.1*/("""
"""),format.raw/*6.75*/(""" 

"""),_display_(Seq(/*8.2*/main/*8.6*/ {_display_(Seq(format.raw/*8.8*/("""
    
    <h1>Add a cat</h1>
    
    """),_display_(Seq(/*12.6*/form(routes.Application.save,'enctype -> "multipart/form-data")/*12.69*/ {_display_(Seq(format.raw/*12.71*/("""
        
        <fieldset>
        
            """),_display_(Seq(/*16.14*/inputText(catForm("name"), '_label -> "Name"))),format.raw/*16.59*/("""
            """),_display_(Seq(/*17.14*/select(
                catForm("gender"), 
                options = options(Genders.list),
                '_default -> "--- Choose a Gender ---",
                '_label -> "Gender"
            ))),format.raw/*22.14*/("""
            
    
	    """),_display_(Seq(/*25.7*/inputText(catForm("color"), '_label -> "Color"))),format.raw/*25.54*/("""
            """),_display_(Seq(/*26.14*/inputText(catForm("birth"), '_label -> "Birthdate"))),format.raw/*26.65*/("""

            """),_display_(Seq(/*28.14*/select(
                catForm("race"), 
                Race.options, 
                '_label -> "Breed", '_default -> "-- Choose a breed --",
                '_showConstraints -> false
            ))),format.raw/*33.14*/("""

	<input type="hidden" name="cattag" value=""""),_display_(Seq(/*35.45*/controllers/*35.56*/.Application.rndInt(1000))),format.raw/*35.81*/("""" /> 

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this entry" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*41.23*/routes/*41.29*/.Application.list())),format.raw/*41.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*44.6*/("""
    
""")))})),format.raw/*46.2*/("""
"""))}
    }
    
    def render(catForm:Form[Cat]) = apply(catForm)
    
    def f:((Form[Cat]) => play.api.templates.Html) = (catForm) => apply(catForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jul 20 12:53:26 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/cdb-test2/app/views/createForm.scala.html
                    HASH: e445d0242545580c3f88aab26dc09476b5580717
                    MATRIX: 513->1|618->43|650->67|724->21|753->41|781->116|814->120|825->124|858->126|927->165|999->228|1034->230|1116->281|1183->326|1228->340|1448->538|1503->563|1572->610|1617->624|1690->675|1736->690|1960->892|2037->938|2057->949|2104->974|2307->1146|2322->1152|2363->1171|2449->1226|2487->1233
                    LINES: 19->1|22->6|22->6|23->1|26->5|27->6|29->8|29->8|29->8|33->12|33->12|33->12|37->16|37->16|38->17|43->22|46->25|46->25|47->26|47->26|49->28|54->33|56->35|56->35|56->35|62->41|62->41|62->41|65->44|67->46
                    -- GENERATED --
                */
            