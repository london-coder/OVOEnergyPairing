import java.time.ZonedDateTime
import scala.language.postfixOps


object Consumption {
	
	def aggregateMonthlyConsumption(snapshots: Seq[(ZonedDateTime, Double)]): Seq[Double] = {

		for {
			i <- 1 to 12 
			mnth = snapshots withFilter { case (d, v) => d.getMonthValue() == i } map { _._2 } sum
		} yield mnth

	}
}