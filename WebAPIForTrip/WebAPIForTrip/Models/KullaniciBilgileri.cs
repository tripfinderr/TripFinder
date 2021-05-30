using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAPIForTrip.Models
{
    public class KullaniciBilgileri
    {

        public int UserId { get; set; }
        public string UserName { get; set; }
        public string UserSurname { get; set; }
        public string UserMailAdress { get; set; }
        public string UserNickName { get; set; }
        public string UserPassword { get; set; }
        public string UserAgainPassword { get; set; }

        public string turIsmi { get; set; }
        public string MekanIsimleri { get; set; }
        public string Kordinatlar { get; set; }



        public string MekanYorumu { get; set; }

        public string Favori { get;set; }



    }
}