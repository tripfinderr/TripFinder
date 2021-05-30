using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebAPIForTrip.Models;

namespace WebAPIForTrip.Controllers
{
    public class denemeController : ApiController
    {
        public HttpResponseMessage Get(string userName)
        {


            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();

            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserName = '" + kullaniciBilgileri.UserName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }
    }
}
