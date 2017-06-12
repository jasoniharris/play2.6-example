package controllers

  import base.BaseFixture
  import play.api.i18n.DefaultMessagesApi
  import play.api.mvc.{ControllerComponents, Result}
  import play.api.test.FakeRequest

  import scala.concurrent.Future
/**
  * Created by jason on 12/06/17.
  */
class HomeControllerSpec extends BaseFixture {

//  val defaultLang: Lang = Lang(java.util.Locale.getDefault)
//  val lang = implicitly[Lang]
  val stubI18nSupport = new DefaultMessagesApi()

  class Setup {
    val mockControllerComponents = mock[ControllerComponents]
    val controller = new controllers.HomeController(mockControllerComponents)
  }

  "Example Page#index" should {
    "should be valid" in new Setup {
      val result: Future[Result] = controller.index().apply(FakeRequest())
      //        val bodyText: String = contentAsString(result)
      result mustBe Ok
    }
  }
}

