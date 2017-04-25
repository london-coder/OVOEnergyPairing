import java.time.ZonedDateTime
import scala.language.postfixOps


object Consumption {
	
	def aggregateMonthlyConsumption(snapshots: Seq[(ZonedDateTime, Double)]): Seq[Double] = {

		val result: Seq[Double] = for {
			i <- 1 to 12 
			mnth = snapshots filter { case (d, v) => d.getMonthValue() == i }
			amnt = mnth map { _._2 } sum
		} yield amnt

		result
	}
}