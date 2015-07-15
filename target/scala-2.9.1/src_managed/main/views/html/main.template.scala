
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.17*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Cats database</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
    </head>
    <body>
        
        <header class="topbar">
            <h1 class="fill">
                <a href=""""),_display_(Seq(/*14.27*/routes/*14.33*/.Application.index())),format.raw/*14.53*/("""">
                  Modified from "Computer database" sample &mdash; Cat database
                </a>
            </h1>
        </header>
        
        <section id="main">
            """),_display_(Seq(/*21.14*/content)),format.raw/*21.21*/("""
        </section>
        
    </body>
</html>
"""))}
    }
    
    def render(content:Html) = apply(content)
    
    def f:((Html) => play.api.templates.Html) = (content) => apply(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jul 12 23:05:29 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/test/app/views/main.scala.html
                    HASH: 0191a2f0f522d3b5918086a2b779e016c8f1df27
                    MATRIX: 502->1|589->16|761->158|775->164|840->207|943->280|957->286|1013->320|1168->444|1183->450|1225->470|1446->660|1475->667
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|35->14|35->14|35->14|42->21|42->21
                    -- GENERATED --
                */
            