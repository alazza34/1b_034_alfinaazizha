// ******************************************************* 
//   Salesperson.java 
//
//   Represents a sales person who has a first name, last 
//   name, and total number of sales. 
// ******************************************************* 
public class Salesperson implements Comparable { 
    private String firstName, lastName; 
    private int totalSales; 

    public Salesperson(String first, String last, int sales) { 
        firstName = first; 
        lastName = last; 
        totalSales = sales; 
    } 

    public String toString() { 
        return lastName + ", " + firstName + ": \t" + totalSales; 
    } 

    public boolean equals(Object other) { 
        return (lastName.equals(((Salesperson)other).getLastName()) && 
                firstName.equals(((Salesperson)other).getFirstName())); 
    } 

    public int compareTo(Object other) { 
        int result; 
        Salesperson otherPerson = (Salesperson) other;
        // cast dulu ke Salesperson supaya bisa akses getSales() dll

        // Bandingkan berdasarkan totalSales
        result = totalSales - otherPerson.getSales();
        // jika result negatif  → this lebih kecil dari other
        // jika result positif  → this lebih besar dari other
        // jika result 0        → sales sama, bandingkan nama

        // Jika sales sama, pakai nama sebagai tiebreaker
        if (result == 0)
        {
            // bandingkan lastName dulu
            result = lastName.compareTo(otherPerson.getLastName());

            // jika lastName juga sama, bandingkan firstName
            if (result == 0)
                result = firstName.compareTo(otherPerson.getFirstName());
        }

        return result; 
    } 

    public String getFirstName() { return firstName; } 
    public String getLastName()  { return lastName; } 
    public int getSales()        { return totalSales; } 
}