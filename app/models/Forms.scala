package models

import play.api.data.Form
import play.api.data.Forms._
import utils.Constants._

/**
  * Created by jason on 23/05/17.
  */
object Forms {

  val signInForm = Form(mapping("user" -> nonEmptyText)(User.apply)(User.unapply))

  val users = List(
    UsersRadioButton(agentAdmin, agentAdmin, agentAdminText, agentAdminButtonText),
    UsersRadioButton(orgAdmin, orgAdmin, orgAdminText, orgAdminButtonText),
    UsersRadioButton(agentAssistant, agentAssistant, agentAssistantText, agentAssistantButtonText),
    UsersRadioButton(orgAssistant, orgAssistant, orgAssistantText, orgAssistantButtonText),
    UsersRadioButton(individual, individual, individualText, individualButtonText)
  )
}
