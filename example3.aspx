// File: Default.aspx 
<%@ Page Language="C#" AutoEventWireup="true" 
         CodeBehind="Default.aspx.cs" Inherits="SecurityAwareness._Default" %>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
   <title>Welcome</title>
</head>
<body>
   <form id="form2" runat="server">
        <div>
           Enter your Name: 
           <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox><br />
           Your Name is 
           <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>.
        </div>
   </form>
</body>
</html> 

// File: Default.aspx.cs
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SecurityAwareness
{
   public partial class _Default : System.Web.UI.Page
   {
        protected void Page_Load(object sender, EventArgs e)
        {
             if (Page.IsPostBack == true)
             {
                  Label1.Text = TextBox1.Text; // unsanitized, take your pick of client side epxloits to run (e.g. mitm and send xss)
             }
        }
   }
}

