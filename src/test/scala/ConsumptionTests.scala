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
		// for feedback
		for ( (xs,i) <- result.view.zipWithIndex ) {
			val ix = i+1
			val fxs = f"$xs%.2f"
			println(s"Aggregate for month $ix: $fxs")
		}
	}
}