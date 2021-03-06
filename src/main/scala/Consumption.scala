import java.time.ZonedDateTime
// import scala.language.postfixOps // to avoid compiler warning.


object Consumption {
	
	def aggregateMonthlyConsumption(snapshots: Seq[(ZonedDateTime, Double)]): Seq[Double] = 
		for {
			i <- 1 to 12 
			mnth = snapshots.view withFilter { case (d, _) => d.getMonthValue() == i } map { _._2 } sum
		} yield mnth
}