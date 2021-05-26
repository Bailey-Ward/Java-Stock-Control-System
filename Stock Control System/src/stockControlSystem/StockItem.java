package stockControlSystem;



public class StockItem {
	/**
	 * Specifies the primitive data types for all attributes
	 */
	private int m_numInStock; 
	private float m_price;
	private String m_description;
	private String m_name;
	
	/**
	 * This sets how the object will be constructed
	 * @param name is the name of the item, set using the setName method
	 * @param description is the description of the item, set using the setDescription method
	 * @param numInStock is the number of the item currently in stock, set using the setNum method
	 * @param price is the price of the object, set using the setPrice method
	 */
	StockItem(String name, String description ,int numInStock, float price) //object 
	{
		m_numInStock = numInStock; 
		m_price = price;
		m_description = description;
		m_name = name;
	}
	/**
	 * returns the number of an item currently in stock 
	 * @return returns the number of the item currently in stock
	 */
	public int getNum() {return m_numInStock;} 
	
	/**
	 * Returns the price of an item
	 * @return returns the price of the item
	 */
	public float getPrice() {return m_price;} 
	/**
	 * Returns the description of an item
	 * @return Returns the description of an item
	 */
	public String getDescription() {return m_description;} 
	/**
	 * returns the name of an item
	 * @return returns the name of an item
	 */
	public String getName() {return m_name;}
	
	/**
	 * Sets the number in stock using the keyboard reader
	 * @param numInStock is the number of the item in stock, this is an int
	 */
	public void setNum(int numInStock) {
		this.m_numInStock = numInStock; 
	}

	/**
	 * Sets the price of the item using the keyboard reader
	 * @param price is the price of the object, which is stored as a float for more accuracy
	 */
	public void setPrice(float price) {
		this.m_price = price; 
	}
	
	/**
	 * sets description using keyboard reader
	 * @param description is the description of the object, stored as a string.
	 */
	public void setDescription(String description) {
		this.m_description = description; 
	}
	
	/**
	 * Sets the name of the object using the keyboard reader
	 * @param name is the name of an item, stored as a string
	 */
	public void setName(String name) {
		this.m_name = name; 
	}

	/**
	 * Protected method which is used to add the attributes of the item, along with commas to separate the values, so they can be correctly input to the csv file
	 * @return returns the attributes of the item, along with commas, to insert them into the csv file
	 */
	protected String toCSV() 
	{
		return m_name + "," + m_description + "," + m_numInStock + "," + m_price;
	}
	
}

