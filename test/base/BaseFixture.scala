package base

import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.mvc.Results

/**
  * Created by jason on 12/06/17.
  */
class BaseFixture extends PlaySpec with Results with MockitoSugar with GuiceOneAppPerSuite
