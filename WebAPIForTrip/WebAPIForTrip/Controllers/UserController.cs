using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

using WebAPIForTrip.Models;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using System.Web.UI.WebControls;
using System.Web;
using System.Web.Mvc;



namespace WebAPIForTrip.Controllers
{
    public class UserController : ApiController
    {
        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("KullaniciBilgileri")]
        public HttpResponseMessage KullaniciBilgileri()
        {
            DataTable table = new DataTable();

            string query = @"SELECT  *  FROM   dbo.UserInformations";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("TurBilgileri")]

        public HttpResponseMessage TurBilgileri()
        {
            DataTable table = new DataTable();

            string query = @"SELECT  *  FROM   dbo.Turlar";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }


        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("MekanBilgileri")]

        public HttpResponseMessage MekanBilgileri([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT MekanIsimleri  FROM   dbo.Turlar where Turİsmi='" + kullaniciBilgileri.turIsmi + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("MekanAciklamasi")]

        public HttpResponseMessage MekanAciklamasi([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT MekanAciklamalari  FROM   dbo.Turlar where MekanIsimleri='" + kullaniciBilgileri.MekanIsimleri + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("KordinatGetir")]

        public HttpResponseMessage KordinatGetir([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT Kordinatlar  FROM   dbo.Turlar where MekanIsimleri='" + kullaniciBilgileri.MekanIsimleri + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }





        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("TurBilgileriDiscent")]

        public HttpResponseMessage TurBilgileriDiscent()
        {
            DataTable table = new DataTable();

            string query = @"SELECT DISTINCT Turİsmi  FROM   dbo.Turlar";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

















        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByIdTurBilgileri")]

        public HttpResponseMessage ByIdTurBilgileri(int id)
        {


            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();

            DataTable table = new DataTable();


            string query = "select * from dbo.Turlar where UserId = '" + id + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByIdKullaniciBilgileri")]

        public HttpResponseMessage ByIdKullaniciBilgileri(int id)
        {


            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();

            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserId = '" + id + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserNameKullaniciBilgileri")]

        public HttpResponseMessage ByUserNameKullaniciBilgileri2(string userName)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserName = '" + userName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByTurIsmi")]
        public HttpResponseMessage ByTurIsmi(string turIsmi)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.Turlar where TurIsmi = '" + turIsmi + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }
        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByKordinat")]
        public HttpResponseMessage ByKordinat(string Kordinat)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.Turlar where Kordinatlar = '" + Kordinat + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }





        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByuserSurnameKullaniciBilgileri")]
        public HttpResponseMessage userSurnameKullaniciBilgileri(string userSurname)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserSurname = '" + userSurname + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }


        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserMailAdressKullaniciBilgileri")]
        public HttpResponseMessage ByUserMailAdressKullaniciBilgileri(string userMailAdress)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserMailAdress = '" + userMailAdress + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }


        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserNickNameKullaniciBilgileri")]

        public HttpResponseMessage ByUserNickNameKullaniciBilgileri5(string userNickName)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserNickName = '" + userNickName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserPasswordKullaniciBilgileri")]
        public HttpResponseMessage ByUserPasswordKullaniciBilgileri(string userPassword)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserPassword = '" + userPassword + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserAgainPassword")]
        public HttpResponseMessage ByUserAgainPassword(string userAgainPassword)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserAgainPassword = '" + userAgainPassword + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("Guncelle")]

        public HttpResponseMessage Guncelle([FromUri]int UserId, [FromBody]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserName = '" + kullaniciBilgileri.UserName + @"'
                    where UserId ='" + UserId + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleSurname")]

        public HttpResponseMessage GuncelleSurname([FromUri]int UserId, [FromBody]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserName = '" + kullaniciBilgileri.UserSurname + @"'
                    where UserId ='" + UserId + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("ASDA")]

        public HttpResponseMessage GuncelleMailAdresi([FromUri]int UserId, [FromBody]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserName = '" + kullaniciBilgileri.UserMailAdress + @"'
                    where UserId ='" + UserId + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleKullaniciAdi")]

        public HttpResponseMessage GuncelleKullaniciAdi([FromUri]int UserId, [FromBody]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserName = '" + kullaniciBilgileri.UserNickName + @"'
                    where UserId ='" + UserId + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }


        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleSifre")]

        public HttpResponseMessage GuncelleSifre([FromUri]int UserId, [FromBody]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserName = '" + kullaniciBilgileri.UserPassword + @"'
                    where UserId ='" + UserId + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }



        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("KayitOl")]

        public string KayitOl(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.UserInformations
               (
                UserName,
                UserSurName,
                UserMailAdress,
                UserNickName,
                UserPassword,
                UserAgainPassword)
                Values
                (
                
                '" + kullaniciBilgileri.UserName + @"'
                ,'" + kullaniciBilgileri.UserSurname + @"'
                ,'" + kullaniciBilgileri.UserMailAdress + @"'
                ,'" + kullaniciBilgileri.UserNickName + @"'
                ,'" + kullaniciBilgileri.UserPassword + @"'
                ,'" + kullaniciBilgileri.UserAgainPassword + @"'
                 )
                ";

                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }

        }

         [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("YorumYap")]

        public string YorumYap(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.Yorumlar
               (
                UserNickName,
                Turİsmi,
                Mekanİsimleri,
                MekanYorumu)
                Values
                (
                
                '" + kullaniciBilgileri.UserNickName + @"'
                ,'" + kullaniciBilgileri.turIsmi + @"'
                ,'" + kullaniciBilgileri.MekanIsimleri + @"'
                ,'" + kullaniciBilgileri.MekanYorumu + @"'
                 )
                ";

                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }





        }

        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("FavEkle")]

        public string FavEkle(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.Favlar
               (
                UserNickName,
                MekanIsimleri,
                Favori)
                Values
                (
                
                '" + kullaniciBilgileri.UserNickName + @"'
                ,'" + kullaniciBilgileri.MekanIsimleri + @"'
                ,'" + kullaniciBilgileri.Favori + @"'
                
                 )
                ";

                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }








        }

    }

}

