string Status = "No";
string sqlstring = "";
try {
	SqlConnection sql = new SqlConnection(
		@"data source=localhost;" +
		"user id=sa;password=password;");
	sql.Open();
	sqlstring = "SELECT HasShipped" +
		" FROM detail WHERE ID='" + Id + "'";
	SqlCommand cmd = new SqlCommand(sqlstring, sql);
	if ((int)cmd.ExecuteScalar() != 0)
		Status = "Yes";
}
catch (SqlException se) {
	Status = sqlstring + " failed\n\r";
	foreach(SqlError e in se.Errors) {
		Status += e.Message + "\n\r";
	}
}
catch (Exception e) {
	Status = e.ToString();
}
