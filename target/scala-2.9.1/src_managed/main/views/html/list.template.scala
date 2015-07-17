
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[scala.Tuple2[Cat, Option[Race]]],Int,String,play.api.mvc.Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[(Cat, Option[Race])], currentOrderBy: Int, currentFilter: String)(implicit flash: play.api.mvc.Flash):play.api.templates.Html = {
        _display_ {import helper._

def /*18.2*/header/*18.8*/(orderBy: Int, title: String):play.api.templates.Html = {_display_(

Seq(format.raw/*18.41*/("""
    <th class="col"""),_display_(Seq(/*19.20*/orderBy)),format.raw/*19.27*/(""" header """),_display_(Seq(/*19.36*/if(scala.math.abs(currentOrderBy) == orderBy){/*19.83*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}})),format.raw/*19.144*/("""">
        <a href=""""),_display_(Seq(/*20.19*/link(0, Some(orderBy)))),format.raw/*20.41*/("""">"""),_display_(Seq(/*20.44*/title)),format.raw/*20.49*/("""</a>
    </th>
""")))};def /*8.2*/link/*8.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.Application.list(newPage, newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy), currentFilter)
    
}};
Seq(format.raw/*1.122*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*7.42*/("""
"""),format.raw/*13.2*/("""

"""),format.raw/*17.37*/("""
"""),format.raw/*22.2*/("""

"""),_display_(Seq(/*24.2*/main/*24.6*/ {_display_(Seq(format.raw/*24.8*/("""
    
    <h1>"""),_display_(Seq(/*26.10*/Messages("cats.list.title", currentPage.total))),format.raw/*26.56*/("""</h1>

    """),_display_(Seq(/*28.6*/flash/*28.11*/.get("success").map/*28.30*/ { message =>_display_(Seq(format.raw/*28.43*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq(/*30.37*/message)),format.raw/*30.44*/("""
        </div>
    """)))})),format.raw/*32.6*/("""

    <div id="actions">
        
        """),_display_(Seq(/*36.10*/helper/*36.16*/.form(action=routes.Application.list())/*36.55*/ {_display_(Seq(format.raw/*36.57*/("""
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq(/*37.66*/currentFilter)),format.raw/*37.79*/("""" placeholder="Filter by cat's name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">

        """)))})),format.raw/*40.10*/("""
        
        <a class="btn success" id="add" href=""""),_display_(Seq(/*42.48*/routes/*42.54*/.Application.create)),format.raw/*42.73*/("""">Add a new cat</a>
        
    </div>
    
    """),_display_(Seq(/*46.6*/Option(currentPage.items)/*46.31*/.filterNot(_.isEmpty).map/*46.56*/ { cats =>_display_(Seq(format.raw/*46.66*/("""
        
        <table class="cats zebra-striped">
            <thead>
                <tr>
                    """),_display_(Seq(/*51.22*/header(2, "Cat's name"))),format.raw/*51.45*/("""
                    """),_display_(Seq(/*52.22*/header(3, "Gender"))),format.raw/*52.41*/("""
		    """),_display_(Seq(/*53.8*/header(4, "Color"))),format.raw/*53.26*/("""
                    """),_display_(Seq(/*54.22*/header(5, "Birthdate"))),format.raw/*54.44*/("""
                    """),_display_(Seq(/*55.22*/header(6, "Breed"))),format.raw/*55.40*/("""
		    """),_display_(Seq(/*56.8*/header(7, "Picture"))),format.raw/*56.28*/("""
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq(/*61.18*/cats/*61.22*/.map/*61.26*/ {/*62.21*/case (cat, race) =>/*62.40*/ {_display_(Seq(format.raw/*62.42*/("""
                        <tr>
                          <td>
			    <a href=""""),_display_(Seq(/*65.18*/routes/*65.24*/.Application.edit(cat.id.get))),format.raw/*65.53*/("""">"""),_display_(Seq(/*65.56*/cat/*65.59*/.name)),format.raw/*65.64*/("""</a>
			  </td>
                          <td>
			    <a href=""""),_display_(Seq(/*68.18*/routes/*68.24*/.Application.edit(cat.id.get))),format.raw/*68.53*/("""">"""),_display_(Seq(/*68.56*/cat/*68.59*/.gender)),format.raw/*68.66*/("""</a>
                          </td>
			   <td>
			    <a href=""""),_display_(Seq(/*71.18*/routes/*71.24*/.Application.edit(cat.id.get))),format.raw/*71.53*/("""">"""),_display_(Seq(/*71.56*/cat/*71.59*/.color)),format.raw/*71.65*/("""</a>
                          </td>
                          <td>
                               """),_display_(Seq(/*74.33*/cat/*74.36*/.birth.map(_.format("dd MMM yyyy")).getOrElse/*74.81*/ {_display_(Seq(format.raw/*74.83*/(""" <em>-</em> """)))})),format.raw/*74.96*/("""
                          </td>
                          <td>
                               """),_display_(Seq(/*77.33*/race/*77.37*/.map(_.name).getOrElse/*77.59*/ {_display_(Seq(format.raw/*77.61*/(""" <em>-</em> """)))})),format.raw/*77.74*/("""
                          </td>
			  <td>

			  <img src=""""),_display_(Seq(/*81.17*/routes/*81.23*/.Application.pickPict(cat.name))),format.raw/*81.54*/("""" width="60" height="45">
 			  <td> """),_display_(Seq(/*82.13*/form(routes.Application.upload(cat.name), 'enctype -> "multipart/form-data")/*82.89*/ {_display_(Seq(format.raw/*82.91*/("""
    
			  <input type="file" name="picture">   <input type="submit" value="Attach this picture"> 
			   
    
			    """)))})),format.raw/*87.9*/("""
                         </td>
			      
			  </td>
                        </tr>
                    """)))}})),format.raw/*93.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq(/*100.18*/currentPage/*100.29*/.prev.map/*100.38*/ { page =>_display_(Seq(format.raw/*100.48*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq(/*102.35*/link(page))),format.raw/*102.45*/("""">&larr; Previous</a>
                    </li> 
                """)))}/*104.18*/.getOrElse/*104.28*/ {_display_(Seq(format.raw/*104.30*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*108.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq(/*110.36*/(currentPage.offset + 1))),format.raw/*110.60*/(""" to """),_display_(Seq(/*110.65*/(currentPage.offset + cats.size))),format.raw/*110.97*/(""" of """),_display_(Seq(/*110.102*/currentPage/*110.113*/.total)),format.raw/*110.119*/("""</a>
                </li>
                """),_display_(Seq(/*112.18*/currentPage/*112.29*/.next.map/*112.38*/ { page =>_display_(Seq(format.raw/*112.48*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq(/*114.35*/link(page))),format.raw/*114.45*/("""">Next &rarr;</a>
                    </li> 
                """)))}/*116.18*/.getOrElse/*116.28*/ {_display_(Seq(format.raw/*116.30*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*120.18*/("""
            </ul>
        </div>
        
    """)))}/*124.6*/.getOrElse/*124.16*/ {_display_(Seq(format.raw/*124.18*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))})),format.raw/*130.6*/("""

        
""")))})),format.raw/*133.2*/("""

            
"""))}
    }
    
    def render(currentPage:Page[scala.Tuple2[Cat, Option[Race]]],currentOrderBy:Int,currentFilter:String,flash:play.api.mvc.Flash) = apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def f:((Page[scala.Tuple2[Cat, Option[Race]]],Int,String) => (play.api.mvc.Flash) => play.api.templates.Html) = (currentPage,currentOrderBy,currentFilter) => (flash) => apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 17 02:23:22 EEST 2015
                    SOURCE: /home/jakuokka/java/play-2.0/test/app/views/list.scala.html
                    HASH: 87f3786e6427189732516ba982c80717887eda65
                    MATRIX: 565->1|762->638|776->644|868->677|919->697|948->704|988->713|1043->760|1128->821|1180->842|1224->864|1258->867|1285->872|1323->268|1334->272|1614->121|1642->140|1670->266|1698->526|1728->636|1756->888|1789->891|1801->895|1835->897|1881->912|1949->958|1991->970|2005->975|2033->994|2079->1007|2191->1088|2220->1095|2272->1116|2346->1159|2361->1165|2409->1204|2444->1206|2541->1272|2576->1285|2754->1431|2842->1488|2857->1494|2898->1513|2978->1563|3012->1588|3046->1613|3089->1623|3235->1738|3280->1761|3333->1783|3374->1802|3412->1810|3452->1828|3505->1850|3549->1872|3602->1894|3642->1912|3680->1920|3722->1940|3835->2022|3848->2026|3861->2030|3872->2054|3900->2073|3935->2075|4044->2153|4059->2159|4110->2188|4144->2191|4156->2194|4183->2199|4278->2263|4293->2269|4344->2298|4378->2301|4390->2304|4419->2311|4515->2376|4530->2382|4581->2411|4615->2414|4627->2417|4655->2423|4786->2523|4798->2526|4852->2571|4887->2573|4932->2586|5059->2682|5072->2686|5103->2708|5138->2710|5183->2723|5274->2783|5289->2789|5342->2820|5411->2858|5496->2934|5531->2936|5681->3055|5818->3177|5974->3301|5995->3312|6014->3321|6058->3331|6163->3404|6196->3414|6282->3480|6302->3490|6338->3492|6509->3630|6614->3703|6661->3727|6698->3732|6753->3764|6791->3769|6813->3780|6843->3786|6919->3830|6940->3841|6959->3850|7003->3860|7108->3933|7141->3943|7223->4005|7243->4015|7279->4017|7446->4151|7513->4199|7533->4209|7569->4211|7707->4317|7751->4329
                    LINES: 19->1|22->18|22->18|24->18|25->19|25->19|25->19|25->19|25->19|26->20|26->20|26->20|26->20|28->8|28->8|34->1|36->4|37->7|38->13|40->17|41->22|43->24|43->24|43->24|45->26|45->26|47->28|47->28|47->28|47->28|49->30|49->30|51->32|55->36|55->36|55->36|55->36|56->37|56->37|59->40|61->42|61->42|61->42|65->46|65->46|65->46|65->46|70->51|70->51|71->52|71->52|72->53|72->53|73->54|73->54|74->55|74->55|75->56|75->56|80->61|80->61|80->61|80->62|80->62|80->62|83->65|83->65|83->65|83->65|83->65|83->65|86->68|86->68|86->68|86->68|86->68|86->68|89->71|89->71|89->71|89->71|89->71|89->71|92->74|92->74|92->74|92->74|92->74|95->77|95->77|95->77|95->77|95->77|99->81|99->81|99->81|100->82|100->82|100->82|105->87|110->93|117->100|117->100|117->100|117->100|119->102|119->102|121->104|121->104|121->104|125->108|127->110|127->110|127->110|127->110|127->110|127->110|127->110|129->112|129->112|129->112|129->112|131->114|131->114|133->116|133->116|133->116|137->120|141->124|141->124|141->124|147->130|150->133
                    -- GENERATED --
                */
            