package controllers

import javax.inject._

import models.Forms.{signInForm, users}
import play.api.i18n.I18nSupport
import play.api.mvc._
import play.filters.csrf.CSRF
import utils.Constants._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()() extends InjectedController with I18nSupport {

  def index = Action { implicit request =>
    Ok(views.html.index("Your new application is ready."))
  }

  def login = Action { implicit request =>
    println(CSRF.getToken)
    Ok(views.html.login(users, signInForm))
  }

  def postLogin = Action { implicit request =>

    val token: Option[CSRF.Token] = CSRF.getToken
    println("CSRF TOKEN  IS: " + token)

    signInForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.login(users, formWithErrors))
      },
      data => {
        buildResponse(data.name)
      }
    )
  }


  def buildResponse(user: String)(implicit req: RequestHeader): Result = {

    val code = generateAuthCode(user)
    Ok(code)
  }

  def generateAuthCode(user: String): String = {
    user match {
      case `agentAdmin` => `agentAdminAuthCode`
      case `orgAdmin` => `orgAdminAuthCode`
      case `agentAssistant` => `agentAssistantAuthCode`
      case `orgAssistant` => `orgAssistantAuthCode`
      case `individual` => `individualAuthCode`
      case _ => `unauthorisedAuthCode`
    }
  }

}
