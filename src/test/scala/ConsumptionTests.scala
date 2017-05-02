import org.scalatest.{FlatSpec, Matchers}
import java.time.ZonedDateTime

class ConsumptionTests extends FlatSpec with Matchers {

	"The size of test data" should "be 37" in {
		assert(DailySnapshotData.Snapshots.size === 37)
	}

	"Annual consmption by month" must "have a size of 12" in {
		val daily = DailySnapshotData.Snapshots.map {
			case (a,b) => (ZonedDateTime.parse(a), b)
		}
		val result = Consumption.aggregateMonthlyConsumption(daily)

		assert(result.size === 12)
		// for visual feedback
		feedback(result)
	}

	def feedback(months: Seq[Double]): Unit = {
		var monthNames = Array("Jan", "Feb", "Mar", "Apr", "May", 
			              "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
		for ( (xs, i) <- months.view.zipWithIndex ) {
			val fxs = f"$xs%.2f"
			println(s"Energy use for ${monthNames(i)}: $fxs")
		}
	}
}