package models

import play.api.data.Form
import play.api.data.Forms._
import utils.Constants.{nativeBAS, nativeBASText, unauthorisedUser, unauthorisedUserText, _}

/**
  * Created by jason on 23/05/17.
  */
object Forms {

  val signInForm = Form(mapping("user" -> nonEmptyText)(User.apply)(User.unapply))

  val users = List(
    RadioButton(agentAdmin, agentAdminText),
    RadioButton(orgAdmin, orgAdminText),
    RadioButton(agentAssistant, agentAssistantText),
    RadioButton(orgAssistant, orgAssistantText),
    RadioButton(individual, individualText),
    RadioButton(nativeBAS, nativeBASText),
    RadioButton(unauthorisedUser, unauthorisedUserText)
  )
}

