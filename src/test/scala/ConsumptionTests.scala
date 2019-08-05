import org.scalatest.{FlatSpec, Matchers}
import java.time.ZonedDateTime

class ConsumptionTests extends FlatSpec with Matchers {

	"The size of test data" should "be 37" in {
		DailySnapshotData.Snapshots.size shouldBe 37
	}

	"Annual consmption by month" must "have a size of 12" in {
		val result = Consumption.aggregateMonthlyConsumption(
			DailySnapshotData.Snapshots map {
				case (a, b) => (ZonedDateTime.parse(a), b)
			})
		result.size shouldBe 12
		
		feedback(result)	// NOT part of the test, only for visual feedback
	}

	// function for human readable output
	def feedback(months: Seq[Double]): Unit = {
		val monthNames = Array("Jan", "Feb", "Mar", "Apr", "May", 
			              "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
		for ( (xs, i) <- months.view.zipWithIndex )
			println(s"Energy use for ${monthNames(i)}: ${"%.2f".format(xs)}")
	}
}