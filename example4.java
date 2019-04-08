public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Page.IsPostBack == true)
        {
            ReadFile();
        }
    }
}
private string ReadFile() 
{
    string productName = Request.QueryString["prodName"];
    string productFile = GetFilename(productName);
    string fileContents = "";
    while (fileContents.Length < 0) 
    {
        try
        {
            fileContents = File.ReadAllText(
                           Path.Combine(Server.MapPath("."),productFile));
        }
        catch 
        {
            Thread.Sleep(10);
        }
    }
    return fileContents;
} 
private string GetFilename(string productName) 
{
    SqlConnection sqlConn = null;
    try
    {
        sqlConn = new SqlConnection("Data Source=localhost;initial 
                      catalog=acme; User ID=sa; password=sqlp@ssword;"); #should be saved in a config file.
        sqlConn.Open();
        SqlCommand sqlComm = new SqlCommand("select filename from products 
                             where name ='" + productName + "';",sqlConn); #sql injectable
        object productFilename = sqlComm.ExecuteScalar();
        if (productName != null)
        {
            return productFilename.ToString();
        }
        else
        {
            return productName;
        }
    }
    finally 
    {
        if (sqlConn != null)
            sqlConn.Close();
    }
}

