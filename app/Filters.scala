import com.google.inject.Inject
import play.api.http.{DefaultHttpFilters, EnabledFilters}
import play.filters.cors.CORSFilter

/**
  * Created by jason on 07/06/17.
  */
class Filters @Inject()(enabledFilters: EnabledFilters, corsFilter: CORSFilter)
  extends DefaultHttpFilters(enabledFilters.filters :+ corsFilter: _*)
