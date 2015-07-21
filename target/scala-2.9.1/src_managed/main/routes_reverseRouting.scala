// @SOURCE:/home/jakuokka/java/play-2.0/cdb-test2/conf/routes
// @HASH:971225e5675a9be029e8f242d335cebdc542da78
// @DATE:Tue Jul 21 11:02:02 EEST 2015

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    


 
// @LINE:32
def pickPict(name:String, cattag:Long) = {
   Call("GET", "/picture" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)), Some(implicitly[QueryStringBindable[Long]].unbind("cattag", cattag)))))
}
                                                        
 
// @LINE:17
def update(id:Long, curname:String, cattag:Long) = {
   Call("POST", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("curname", curname)), Some(implicitly[QueryStringBindable[Long]].unbind("cattag", cattag)))))
}
                                                        
 
// @LINE:9
def list(p:Int = 0, s:Int = 2, f:String = "") = {
   Call("GET", "/cats" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == 2) None else Some(implicitly[QueryStringBindable[Int]].unbind("s", s)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:21
// @LINE:20
def delete(id:Long) = {
   (id) match {
// @LINE:20
case (id) if true => Call("GET", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
                                                                
// @LINE:21
case (id) if true => Call("POST", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
                                                                    
   }
}
                                                        
 
// @LINE:12
def create() = {
   Call("GET", "/cats/new")
}
                                                        
 
// @LINE:31
def deletePictreturn(id:Long) = {
   Call("GET", "/picture/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:13
def save() = {
   Call("POST", "/cats")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:16
def edit(id:Long) = {
   Call("GET", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:30
def upload(name:String, cattag:Long) = {
   Call("POST", "/" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)), Some(implicitly[QueryStringBindable[Long]].unbind("cattag", cattag)))))
}
                                                        

                      
    
}
                            

// @LINE:27
// @LINE:26
class ReverseAssets {
    


 
// @LINE:27
// @LINE:26
def at(file:String) = {
   (file) match {
// @LINE:26
case (file) if true => Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                                
// @LINE:27
case (file) if true => Call("POST", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                                    
   }
}
                                                        

                      
    
}
                            
}
                    


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    


 
// @LINE:32
def pickPict = JavascriptReverseRoute(
   "controllers.Application.pickPict",
   """
      function(name,cattag) {
      return _wA({method:"GET", url:"/picture" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cattag", cattag)])})
      }
   """
)
                                                        
 
// @LINE:17
def update = JavascriptReverseRoute(
   "controllers.Application.update",
   """
      function(id,curname,cattag) {
      return _wA({method:"POST", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("curname", curname), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cattag", cattag)])})
      }
   """
)
                                                        
 
// @LINE:9
def list = JavascriptReverseRoute(
   "controllers.Application.list",
   """
      function(p,s,f) {
      return _wA({method:"GET", url:"/cats" + _qS([(p == """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == """ +  implicitly[JavascriptLitteral[Int]].to(2) + """ ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("s", s)), (f == """ +  implicitly[JavascriptLitteral[String]].to("") + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:21
// @LINE:20
def delete = JavascriptReverseRoute(
   "controllers.Application.delete",
   """
      function(id) {
      if (true) {
      return _wA({method:"GET", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
      if (true) {
      return _wA({method:"POST", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
      }
   """
)
                                                        
 
// @LINE:12
def create = JavascriptReverseRoute(
   "controllers.Application.create",
   """
      function() {
      return _wA({method:"GET", url:"/cats/new"})
      }
   """
)
                                                        
 
// @LINE:31
def deletePictreturn = JavascriptReverseRoute(
   "controllers.Application.deletePictreturn",
   """
      function(id) {
      return _wA({method:"GET", url:"/picture/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:13
def save = JavascriptReverseRoute(
   "controllers.Application.save",
   """
      function() {
      return _wA({method:"POST", url:"/cats"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:16
def edit = JavascriptReverseRoute(
   "controllers.Application.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:30
def upload = JavascriptReverseRoute(
   "controllers.Application.upload",
   """
      function(name,cattag) {
      return _wA({method:"POST", url:"/" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cattag", cattag)])})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:27
// @LINE:26
class ReverseAssets {
    


 
// @LINE:27
// @LINE:26
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (true) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      if (true) {
      return _wA({method:"POST", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    


 
// @LINE:32
def pickPict(name:String, cattag:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.pickPict(name, cattag), HandlerDef(this, "controllers.Application", "pickPict", Seq(classOf[String], classOf[Long]))
)
                              
 
// @LINE:17
def update(id:Long, curname:String, cattag:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.update(id, curname, cattag), HandlerDef(this, "controllers.Application", "update", Seq(classOf[Long], classOf[String], classOf[Long]))
)
                              
 
// @LINE:9
def list(p:Int, s:Int, f:String) = new play.api.mvc.HandlerRef(
   controllers.Application.list(p, s, f), HandlerDef(this, "controllers.Application", "list", Seq(classOf[Int], classOf[Int], classOf[String]))
)
                              
 
// @LINE:20
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.delete(id), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:12
def create() = new play.api.mvc.HandlerRef(
   controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Seq())
)
                              
 
// @LINE:31
def deletePictreturn(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.deletePictreturn(id), HandlerDef(this, "controllers.Application", "deletePictreturn", Seq(classOf[Long]))
)
                              
 
// @LINE:13
def save() = new play.api.mvc.HandlerRef(
   controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:16
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.edit(id), HandlerDef(this, "controllers.Application", "edit", Seq(classOf[Long]))
)
                              
 
// @LINE:30
def upload(name:String, cattag:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.upload(name, cattag), HandlerDef(this, "controllers.Application", "upload", Seq(classOf[String], classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:27
// @LINE:26
class ReverseAssets {
    


 
// @LINE:26
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                