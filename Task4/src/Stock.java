
public class Stock {

	// Variables declaration
	private String stockName;
	private double initialPrace;
	private double currentPrice;
	private double rateOfReturn;

	// Default constructor
	public Stock() {
	}

	// Constructor inilizing only two variables
	public Stock(String stockName, double initialPrace) {
		this.stockName = stockName;
		this.initialPrace = initialPrace;
	}

	// Constructors initilizing all variables
	public Stock(String stockName, double initialPrace, double currentPrice, double rateOfReturn) {
		this.stockName = stockName;
		this.initialPrace = initialPrace;
		this.currentPrice = currentPrice;
		this.rateOfReturn = rateOfReturn;
	}

	// -----------------------------------------------------------------------------------------------

	// Getters
	public String getStockName() {
		return stockName;
	}

	public double getInitialPrice() {
		return initialPrace;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public double getRateOfReturn() {
		return rateOfReturn;
	}

	// Setters
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public void setInitialPrice(double initialPrace) {
		this.initialPrace = initialPrace;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public void setRateOfReturn(double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	// -----------------------------------------------------------------------------------------------

	// Method to calculate the current price base on the fluctuation rate
	public double calculatingCurrentPrice(double fluctRate) {
		return (this.currentPrice * fluctRate);
	}

	// Method to calculate the rate of return base on the current price and initial
	// price
	public double calculatingRor(double currentPrice) {
		return ((currentPrice - this.initialPrace) / this.initialPrace) * 100;
	}

	public double calculatePercentage(double fluctRate) {
		return (fluctRate - 1) * 100;
	}

	// Method for updating current price and rate of return with given fluctuation
	// rate
	public void updateStockInfo(double flucRate) {

		if (this.calculatePercentage(flucRate) > 0 && this.calculatingRor(this.getCurrentPrice()) > 0) {
			System.out.printf("%s's daily fluctuation rate is +%.2f %%\n" + "%s: %.2f USD (+%.2f %%)\n", this.stockName,
					this.calculatePercentage(flucRate), this.stockName, this.getCurrentPrice(),
					this.calculatingRor(this.getCurrentPrice()));
		} else if (this.calculatePercentage(flucRate) > 0 && this.calculatingRor(this.getCurrentPrice()) < 0) {
			System.out.printf("%s's daily fluctuation rate is +%.2f %%\n" + "%s: %.2f USD (%.2f %%)\n", this.stockName,
					this.calculatePercentage(flucRate), this.stockName, this.getCurrentPrice(),
					this.calculatingRor(this.getCurrentPrice()));
		} else if (this.calculatePercentage(flucRate) < 0 && this.calculatingRor(this.getCurrentPrice()) > 0) {
			System.out.printf("%s's daily fluctuation rate is %.2f %%\n" + "%s: %.2f USD (+%.2f %%)\n", this.stockName,
					this.calculatePercentage(flucRate), this.stockName, this.getCurrentPrice(),
					this.calculatingRor(this.getCurrentPrice()));
		} else {
			System.out.printf("%s's daily fluctuation rate is %.2f %%\n" + "%s: %.2f USD (%.2f %%)\n", this.stockName,
					this.calculatePercentage(flucRate), this.stockName, this.getCurrentPrice(),
					this.calculatingRor(this.getCurrentPrice()));
		}

	}
}
