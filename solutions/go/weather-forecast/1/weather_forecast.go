// Package weather provides the forecast information.
package weather

var (
	// CurrentCondition represents the current weather condition.
	CurrentCondition string

	// CurrentLocation represents a city.
	CurrentLocation  string
)

// Forecast returns a formatted string representing the current weather conditions in the city.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
