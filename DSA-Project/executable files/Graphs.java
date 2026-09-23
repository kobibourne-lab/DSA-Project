//Students: Kobi Bourne 
//          Sarah Crotty
//Purpose: Class to store graph and its methods
public class Graphs 
{

    //declares and initalizes Array of site names
    String[] sites = {"The Lords Woods", "High Park", "Rathwood", "Mullaghreelan Woods", "Glendalough", "Sally's Gap", "The Wicklow Way"};
    //declares Adjacency matrix(2-D Array) storing distances
    double[][] matrix = 
    {
        {0, 3.2, 2.8, 0, 0, 0, 0},
        {0, 0, 1.4, 0, 0, 0, 0},
        {0, 1.4, 0, 3.2, 3.2, 0, 0},
        {0, 0, 0, 0, 2, 5, 0},
        {0, 0, 3.2, 2, 0, 3.6, 0},
        {0, 0, 0, 0, 0, 0, 1.4},
        {0, 0, 0, 0, 0, 1.4, 0}
    };

    //method to get index of site
    private int getIndex(String site)
    {
        for(int index = 0; index < sites.length; index++) //loops through all sites
            {
                if(sites[index].equalsIgnoreCase(site)) //if site = site at current index
                    {
                        return index; //return site at index 
                    }
            }
        return -1; //if not found return -1
    }

    //method to print all leaving connectings for site
    public void Search(String site)
    {
        int index;
        index = getIndex(site); //get index of site calling method 

        if(index == -1) //if site not found 
            {
                return; //exit method
            }

        System.out.println(site + " -->"); // print site

        for(int col = 0; col < sites.length; col++) //loops through cloumns in sites row
            {
                if(matrix[index][col] !=0) //if connection
                    {
                        System.out.println(sites[col] + " ( " + matrix[index][col] + " ) "); //print site and distance 
                    }
            }
        System.out.println(); // line for spacing

    }


    //add connection
    public void Insert(String site1, String site2, double weight)
    {
        int row;
        int col;

        row = getIndex(site1); //get site1 row
        col = getIndex(site2);  //get site2 col

        if(row != -1 && col != -1)
            {
                matrix[row][col] = weight; //add connection, store distance at row,col
            }
        System.out.println("Added new connection");
        System.out.println(); //line for spacing
    }

    //print all connected sites
    public void AllCons(String site)
    {
        int index;
        index = getIndex(site); //get index of site calling method 

        if(index == -1) //if site not found 
            {
                return; //exit method
            }

        System.out.println(site + " Connections -->"); // print site

        for(int col = 0; col < sites.length; col++) //loops through cloumns in sites row
            {
                if(matrix[index][col] !=0) //if connection
                    {
                        System.out.println(sites[col]); //print connected sites
                    }
            }
        System.out.println(); // spacing
    }

    //print closest site
    public void Closest(String site)
    {
        int index;
        int nearest;
        double min;

        index = getIndex(site); //get index of site calling method 

        if(index == -1) //if site not found 
            {
                return; //exit method
            }

        nearest = -1; //closest site index
        min = -1; //smallest distance so far

        for(int col = 0; col < sites.length; col++) //loops through cloumns
            {
                if(matrix[index][col] !=0) //if connection
                    {
                        if(min == -1 || matrix[index][col] < min) //if first or smaller
                            {
                                min = matrix[index][col]; //updates min
                                nearest = col; //update nearest
                            }
                    }
            }
        if(nearest != -1) //if nearest not =-1
            {
                System.out.println("The closest site to " + site + " is " + sites[nearest]); //print nearest site
            }
        
    }
    
}
