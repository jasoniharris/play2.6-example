package models

/**
  * Created by jason on 06/06/17.
  */
case class RadioButton(value: String, text: String) {
  def id: String = value + "Btn"
  def labelId: String = value + "Lbl"
}