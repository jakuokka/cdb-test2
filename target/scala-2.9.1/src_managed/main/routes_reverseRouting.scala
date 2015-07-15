// @SOURCE:/home/jakuokka/java/play-2.0/test/conf/routes
// @HASH:88482c0fe9ca0e41f28f34c2e3040bbc099be7ef
// @DATE:Thu Jul 16 01:14:53 EEST 2015

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


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
    


 
// @LINE:30
def upload(name:String) = {
   Call("POST", "/" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                                                        
 
// @LINE:9
def list(p:Int = 0, s:Int = 2, f:String = "") = {
   Call("GET", "/cats" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == 2) None else Some(implicitly[QueryStringBindable[Int]].unbind("s", s)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:16
def edit(id:Long, name:String) = {
   Call("GET", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                                                        
 
// @LINE:31
def pickPict(name:String) = {
   Call("GET", "/picture/" + implicitly[PathBindable[String]].unbind("name", name))
}
                                                        
 
// @LINE:17
def update(id:Long, name:String) = {
   Call("POST", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                                                        
 
// @LINE:12
def create() = {
   Call("GET", "/cats/new")
}
                                                        
 
// @LINE:13
def save() = {
   Call("POST", "/cats")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:21
// @LINE:20
def delete(id:Long, name:String) = {
   (id, name) match {
// @LINE:20
case (id, name) if true => Call("GET", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
                                                                
// @LINE:21
case (id, name) if true => Call("POST", "/cats/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
                                                                    
   }
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
    


 
// @LINE:30
def upload = JavascriptReverseRoute(
   "controllers.Application.upload",
   """
      function(name) {
      return _wA({method:"POST", url:"/" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
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
                                                        
 
// @LINE:16
def edit = JavascriptReverseRoute(
   "controllers.Application.edit",
   """
      function(id,name) {
      return _wA({method:"GET", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
   """
)
                                                        
 
// @LINE:31
def pickPict = JavascriptReverseRoute(
   "controllers.Application.pickPict",
   """
      function(name) {
      return _wA({method:"GET", url:"/picture/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
   """
)
                                                        
 
// @LINE:17
def update = JavascriptReverseRoute(
   "controllers.Application.update",
   """
      function(id,name) {
      return _wA({method:"POST", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
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
                                                        
 
// @LINE:21
// @LINE:20
def delete = JavascriptReverseRoute(
   "controllers.Application.delete",
   """
      function(id, name) {
      if (true) {
      return _wA({method:"GET", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
      if (true) {
      return _wA({method:"POST", url:"/cats/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
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
    


 
// @LINE:30
def upload(name:String) = new play.api.mvc.HandlerRef(
   controllers.Application.upload(name), HandlerDef(this, "controllers.Application", "upload", Seq(classOf[String]))
)
                              
 
// @LINE:9
def list(p:Int, s:Int, f:String) = new play.api.mvc.HandlerRef(
   controllers.Application.list(p, s, f), HandlerDef(this, "controllers.Application", "list", Seq(classOf[Int], classOf[Int], classOf[String]))
)
                              
 
// @LINE:16
def edit(id:Long, name:String) = new play.api.mvc.HandlerRef(
   controllers.Application.edit(id, name), HandlerDef(this, "controllers.Application", "edit", Seq(classOf[Long], classOf[String]))
)
                              
 
// @LINE:31
def pickPict(name:String) = new play.api.mvc.HandlerRef(
   controllers.Application.pickPict(name), HandlerDef(this, "controllers.Application", "pickPict", Seq(classOf[String]))
)
                              
 
// @LINE:17
def update(id:Long, name:String) = new play.api.mvc.HandlerRef(
   controllers.Application.update(id, name), HandlerDef(this, "controllers.Application", "update", Seq(classOf[Long], classOf[String]))
)
                              
 
// @LINE:12
def create() = new play.api.mvc.HandlerRef(
   controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Seq())
)
                              
 
// @LINE:13
def save() = new play.api.mvc.HandlerRef(
   controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:20
def delete(id:Long, name:String) = new play.api.mvc.HandlerRef(
   controllers.Application.delete(id, name), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long], classOf[String]))
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
                    
                