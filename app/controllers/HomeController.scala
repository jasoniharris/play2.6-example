package controllers


import com.google.inject.Inject
import models.Forms.{signInForm, users}
import play.api.i18n.I18nSupport
import play.api.mvc._
import play.filters.csrf.CSRF
import utils.Constants._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
class HomeController @Inject()(components: ControllerComponents)
  extends AbstractController(components) with I18nSupport {

  def index() = Action { implicit request =>
    Ok("Ok")
  }


  /** GET /loginContent
    *
    * Renders loginContentContent.scala.html view and form
    * Passes list of valid users
    * CSRF token passed via global Filters
    *
    * @return
    */
  def login = Action { implicit request =>
    println(s"loginContent CSRF TOKEN: ${CSRF.getToken}")
    Ok(views.html.login(users, signInForm))
  }

  def postLogin = Action { implicit request =>
    val token: Option[CSRF.Token] = CSRF.getToken
    println("postLogin CSRF TOKEN: " + token)

    signInForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.login(users, formWithErrors))
      },
      data => {
        Ok(generateAuthCode(data.name))
      }
    )
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
