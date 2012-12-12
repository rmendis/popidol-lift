package com.svgobjects
package snippet

import net.liftweb.http.S
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.http.SessionVar
import net.liftweb.common.Box
import net.liftweb.common.Full
import net.liftweb.common.Empty

/**
 * stateless
 */
object Popidol {
  // app state
  @volatile var gvotes:Double = 1
  @volatile var wvotes:Double = 1
  
  def total = gvotes + wvotes  
    
  def render = {
    S.param("vote") match {
      case Full(vote) => vote match {
      	case "will" => wvotes+=1 
      	case "garath" => gvotes+=1
      }
      case _ => {}
    }
    
    "#garath [transform]" #> {"scale(" + gvotes/total + ")"} &
  	"#will [transform]" #> {"scale(" + wvotes/total + ")"}
  }
}
