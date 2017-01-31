package linkedIn;

/**This class is made to represent a company. The fields are basic enough to give a general idea of the company. As of now the only use for this class is to tell which company is bigger. 
 * @author Matt Bell
 * @since Feb 16, 2014
 * @status This class works save a bug with the Companies owned feature and deep cloning the object with the constructor.
 * 
 */
public class Company {
	private String name;// the Name of the Company
	private char type;//the type of the Company 'D' for domestic 'O' for overseas or 'I' for international
	private int yearOfFounding;//the year the company was founded 
	private int employees;//the number of employees that the company has
	private Company Parent;//The owner company of the company 
	private int companies;//The number of companies that the company owns
	private int id;//The ID number of the company
	
	
	
	/**Constructor:a new company; The company has no id number, it has no parent company, and it owns no companies.
	 *Precondition:  All parameters are valid as described
	 * 
	 * @param name the name of the company
	 * @param year the year of foundation
	 * @param employee number of the employees 
	 * @param type the type of company 
	 */
	public Company(String name,int year,int employee,char type){
		this.setName(name);
		this.setYearOfFounding(year);
		this.setEmployees(employee);
		this.setType(type);
		this.setId(-1);
		this.companies=0;
		
	}
	/**
	 * a new Company Parameters are in order.
	 * Precondition: All parameters are valid as described ; the parent is not null; the ID number > 0
	 * @param name
	 * @param type
	 * @param parent
	 * @param year
	 * @param employees
	 * @param id
	 */
	Company(String name,char type,Company parent,int year,int employees,int id){
		this.setName(name);
		this.setType(type);
		this.setParent(parent);
		this.setYearOfFounding(year);
		this.setEmployees(employees);
		this.setId(id);
	}
	/**
	 * Creates this to be an deep copy of ExistingCompany
	 * @param ExistingCompany an existing company object
	 */
	Company(Company ExistingCompany){
		this.companies=ExistingCompany.getCompanies();
		this.setEmployees(ExistingCompany.getEmployees());
		this.setId(ExistingCompany.getId());
		this.setName(ExistingCompany.getName());
		if(ExistingCompany.getParent()!= null){
			this.setParent(new Company(ExistingCompany.getParent()));
		}
		this.setType(ExistingCompany.getType());
		this.setYearOfFounding(ExistingCompany.getYearOfFounding());
	}
	/**
	 * Default constructor. Sets The name of the Company to ("NO_NAME") sets the number of employees to (0)
	 * sets the ID to (-1) sets the type to ('D') sets the year of founding to (1969) and sets the number of companies owned to (0) 
	 */
	Company(){
		this.companies=0;
		this.setEmployees(0);
		this.setId(-1);
		this.setName("NO_NAME");
		this.setType(('D'));
		this.setYearOfFounding(1969);
	}
	/**
	 * @return the name of this Company
	 */
	public String getName() {
		assert name == this.name;
		return name;
	}
	/**Sets the name of this company to (name)
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
		assert this.name.equals(name);
	}
	/**
	 * @return the type of the Company 'D' for domestic 'O' for overseas or 'I' for international
	 */
	public char getType() {
		assert type == this.type;
		return type;
	}
	/**Precondition: (type) is one of 'D', 'O', and 'I'
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
		assert this.type == type;
	}
	/**
	 * @return the year the company was founded 
	 */
	public int getYearOfFounding() {
		assert yearOfFounding == this.yearOfFounding;
		return yearOfFounding;
	}
	/**Set the year this company was founded to (yearOfFounding)
	 * @param yearOfFounding the year Of Founding to set
	 */
	public void setYearOfFounding(int yearOfFounding) {
		this.yearOfFounding = yearOfFounding;
		assert this.yearOfFounding == yearOfFounding;
	}
	/**
	 * @return the number of employees that the company has
	 */
	public int getEmployees() {
		assert this.employees == this.employees;
		return employees;
	}
	/**Set the number of employees of this company to (employees)
	 * Precondition: (employees) > 0
	 * @param employees the employees to set
	 */
	public void setEmployees(int employees) {
		this.employees = employees;
		assert this.employees == employees;
	}
	/** Returns a Company Object reference; the owner company of the company
	 * @return The owner company reference of the company
	 */
	public Company getParent() {
		if(Parent == null){
			return Parent;
		}
		assert this.Parent.equals(Parent);
		return Parent;
	}
	/**sets the parent of this company to (parent)
	 * @Precondition: thisCompanu's parent is null, and the param (parent) is not null.
	 * @param parent the parent to set
	 */
	public void setParent(Company parent) {
		Parent = parent;
		parent.companies=parent.getCompanies()+1;
		assert this.Parent.equals(parent);
	}
	/**
	 * @return The number of companies that the company owns
	 */
	public int getCompanies() {
		assert companies == this.companies;
		return companies;
	}
	/**
	 * @return The ID number of the company
	 */
	public int getId() {
		assert id == id;
		return id;
	}
	/**
	 * Evaluates the fact that this is a bigger company than c.
	 * @param c Company to compare to this
	 * @return the truth of this being a bigger company than c.
	 */
	public boolean isBigger(Company c){
		assert this.getEmployees() > c.getEmployees() == true || this.getEmployees() > c.getEmployees() == false;
		return this.getEmployees() > c.getEmployees();
	}
	/**
	 * evaluates the truth of c1 being a bigger comopany than c2.
	 * @see linkedIn.Company.isBigger(Company c)
	 * @param c1 the proposed bigger company 
	 * @param c2 the proposed smaller company 
	 * @return the truth of c1 being a bigger company than c2.
	 */
	public static boolean isBigger(Company c1,Company c2){
		assert c1.getEmployees()>c2.getEmployees() == true||c1.getEmployees()>c2.getEmployees() == false;
		return c1.getEmployees()>c2.getEmployees();
	}
	/**Sets this company's ID number to (idNumber)
	 * Precondition:  idNumber >= 0 && this's id number is still curentlly -1
	 *  @param idNumber the idNumber to set
	 */
	public void setId(int idNumber) {
		this.id = idNumber;
		assert this.id == idNumber;
	}
	/** A string representation of the company Object
	 * @see java.lang.Object#toString()
	 *  
	 */
	public String toString() {
		/*return "Company [name=" + name + ", type=" + type + ", yearOfFounding="
				+ yearOfFounding + ", employees=" + employees + ", Parent="
				+ (Parent != null?Parent.getName():"no Parent") + ", Companies=" + companies + ", id=" + id + "]";
				*/
		assert "" + type + " Company " + name + ". ID: " + id + ". Founded " + yearOfFounding +
			". Has " + employees + " employees. " + " Owns " + companies + ((companies > 1) || (companies == 0)?" companies.":" company.") /*+ ((Parent != null?" Is owned by " + Parent.getName() +".":""))*/ != super.toString();
		return "" + type + " Company " + name + (id!=-1?". ID: " + id:"") +". Founded " + yearOfFounding +
					". Has " + employees + " employees. " + " Owns " + companies + ((companies > 1) || (companies == 0)?" companies.":" company.") + ((Parent != null?" Is owned by " + Parent.getName() +".":""));
		
		
			
	}

}
