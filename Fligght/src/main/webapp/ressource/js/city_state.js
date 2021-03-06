////////////////////////////////////////////////////////////////////////////
// city_state.js ///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

var countries = Object();

countries['Africa'] = '|Algeria|Angola|Benin|Botswana|Burkina Faso|Burundi|Cameroon|Cape Verde|Central African Republic|Chad|Comoros|Congo, Dem.|Congo, Rep.|Djibouti|Egypt|Equatorial Guinea|Eritrea|Ethiopia|Gabon|Gambia|Ghana|Guinea|Guinea-Bissau|Kenya|Lesotho|Liberia|Libya|Madagascar|Malawi|Mali|Mauritania|Mauritius|Morocco|Mozambique|Namibia|Niger|Nigeria|Rwanda|Sao Tome/Principe|Senegal|Seychelles|Sierra Leone|Somalia|South Africa|Sudan|Swaziland|Tanzania|Togo|Tunisia|Uganda|Zambia|Zimbabwe';
countries['Antarctica'] = '|Amundsen-Scott';
countries['Asia'] = '|Bangladesh|Bhutan|Brunei|Burma (Myanmar)|Cambodia|China|East Timor|India|Indonesia|Japan|Kazakhstan|Korea (north)|Korea (south)|Laos|Malaysia|Maldives|Mongolia|Nepal|Philippines|Russian Federation|Singapore|Sri Lanka|Taiwan|Thailand|Vietnam';
countries['Australia/Oceania'] = '|Australia|Fiji|Kiribati|Micronesia|Nauru|New Zealand|Palau|Papua New Guinea|Samoa|Tonga|Tuvalu|Vanuatu';
countries['Caribbean'] = '|Anguilla|Antigua/Barbuda|Aruba|Bahamas|Barbados|Cozumel|Cuba|Dominica|Dominican Republic|Grenada|Guadeloupe|Haiti|Jamaica|Martinique|Montserrat|Netherlands Antilles|Puerto Rico|St. Barts|St. Kitts/Nevis|St. Lucia|St. Martin/Sint Maarten|St Vincent/Grenadines|San Andres|Trinidad/Tobago|Turks/Caicos';
countries['Central America'] = '|Belize|Costa Rica|El Salvador|Guatemala|Honduras|Nicaragua|Panama';
countries['Europe'] = '|Albania|Andorra|Austria|Belarus|Belgium|Bosnia-Herzegovina|Bulgaria|Croatia|Czech Republic|Denmark|Estonia|Finland|France|Georgia|Germany|Greece|Hungary|Iceland|Ireland|Italy|Latvia|Liechtenstein|Lithuania|Luxembourg|Macedonia|Malta|Moldova|Monaco|Netherlands|Norway|Poland|Portugal|Romania|San Marino|Serbia/Montenegro (Yugoslavia)|Slovakia|Slovenia|Spain|Sweden|Switzerland|Ukraine|United Kingdom|Vatican City';
countries['Islands'] = '|Arctic Ocean|Atlantic Ocean (North)|Atlantic Ocean (South)|Assorted|Caribbean Sea|Greek Isles|Indian Ocean|Mediterranean Sea|Oceania|Pacific Ocean (North)|Pacific Ocean (South)';
countries['Middle East'] = '|Afghanistan|Armenia|Azerbaijan|Bahrain|Cyprus|Iran|Iraq|Israel|Jordan|Kuwait|Kyrgyzstan|Lebanon|Oman|Pakistan|Qatar|Saudi Arabia|Syria|Tajikistan|Turkey|Turkmenistan|United Arab Emirates|Uzbekistan|Yemen';
countries['North America'] = '|Bermuda|Canada|Greenland|Mexico|United States';
countries['South America'] = '|Argentina|Bolivia|Brazil|Chile|Colombia|Ecuador|Guyana|Paraguay|Peru|Suriname|Uruguay|Venezuela';

////////////////////////////////////////////////////////////////////////////

var city_states = Object();

city_states['Morocco'] = '|Rabat||Dakhla|Agadir|Al Hoceima|Azilal|Beni Mellal|Ben Slimane|Boujdour|Boulemane|Casablanca|Chaouen|El Jadida|El Kelaa des Sraghna|Er Rachidia|Essaouira|Es Smara|Fès|Figuig|Guelmim|Ifrane|Kenitra|Khemisset|Khenifra|Khouribga|Laayoune|Larache|Marrakech|Meknes|Nador|Ouarzazate|Oujda|Safi|Settat|Salé|Sidi Kacem|Tanger|Tan-Tan|Taounate|Taroudannt|Tata|Taza|Tetouan|Tiznit';


city_states['France'] = '|Nantes|Cannes|Grenoble|Montpellier|Mulhouse|Toulouse|Lyon|Marseille|Nice|Paris||Alsace|Aquitaine|Auvergne|Basse-Normandie|Bourgogne|Bretagne|Centre|Champagne-Ardenne|Corse|Franche-Comte|Haute-Normandie|Ile-de-France|Languedoc-Roussillon|Limousin|Lorraine|Midi-Pyrenees|Nord-Pas-de-Calais|Pays de la Loire|Picardie|Poitou-Charentes|Provence-Alpes-Cote d\'Azur|Rhone-Alpes';


city_states['Germany'] = '|berlin|Düsseldorf|Munich|Francfort|Berlin||Baden-Wuerttemberg|Bayern|Berlin|Brandenburg|Bremen|Hamburg|Hessen|Mecklenburg-Vorpommern|Niedersachsen|Nordrhein-Westfalen|Rheinland-Pfalz|Saarland|Sachsen|Sachsen-Anhalt|Schleswig-Holstein|Thueringen';


city_states['Italy'] = '|Pise|milan|Rome||Abruzzi|Basilicata|Calabria|Campania|Emilia-Romagna|Friuli-Venezia Giulia|Lazio|Liguria|Lombardia|Marche|Molise|Piemonte|Puglia|Sardegna|Sicilia|Toscana|Trentino-Alto Adige|Umbria|Valle d\'Aosta|Veneto';


city_states['Switzerland'] = '|Genève|Bern||Aargau|Appenzell Ausser-Rhoden|Appenzell Inner-Rhoden|Basel-Landschaft|Basel-Stadt|Fribourg|Geneve|Glarus|Graubunden|Jura|Luzern|Neuchatel|Nidwalden|Obwalden|Sankt Gallen|Schaffhausen|Schwyz|Solothurn|Thurgau|Ticino|Uri|Valais|Vaud|Zug|Zurich';


city_states['Spain'] = '|Madrid||Andalucia|Aragon|Asturias|Baleares (Balearic Islands)|Ceuta|Canarias (Canary Islands)|Cantabria|Castilla-La Mancha|Castilla y Leon|Cataluna|Communidad Valencian|Extremadura|Galicia|La Rioja|Melilla|Murcia|Navarra|Pais Vasco (Basque Country)';


city_states['Sweden'] = '|Stockholm||Blekinge|Dalarnas|Gavleborgs|Gotlands|Hallands|Jamtlands|Jonkopings|Kalmar|Kronobergs|Norrbottens|Orebro|Ostergotlands|Skane|Sodermanlands|Uppsala|Varmlands|Vasterbottens|Vasternorrlands|Vastmanlands|Vastra Gotalands';


city_states['Greece'] = '|Athènes|At|hens||Agion Oros (Mt. Athos)|Achaia|Aitolia kai Akarmania|Argolis|Arkadia|Arta|Attiki|Chalkidiki|Chanion|Chios|Dodekanisos|Drama|Evros|Evrytania|Evvoia|Florina|Fokidos|Fthiotis|Grevena|Ileia|Imathia|Ioannina|Irakleion|Karditsa|Kastoria|Kavala|Kefallinia|Kerkyra|Kilkis|Korinthia|Kozani|Kyklades|Lakonia|Larisa|Lasithi|Lefkas|Lesvos|Magnisia|Messinia|Pella|Pieria|Preveza|Rethynnis|Rodopi|Samos|Serrai|Thesprotia|Thessaloniki|Trikala|Voiotia|Xanthi|Zakynthos';


city_states['Poland'] = '|Varsovie|Warsaw||Dolnoslaskie|Kujawsko-Pomorskie|Lodzkie|Lubelskie|Lubuskie|Malopolskie|Mazowieckie|Opolskie|Podkarpackie|Podlaskie|Pomorskie|Slaskie|Swietokrzyskie|Warminsko-Mazurskie|Wielkopolskie|Zachodniopomorskie';


city_states['Belgium'] = '|Bruxelles|Brussels||Antwerpen|Brabant Wallon|Brussels (Bruxelles)|Hainaut|Liege|Limburg|Luxembourg|Namur|Oost-Vlaanderen|Vlaams-Brabant|West-Vlaanderen';


city_states['Austria'] = '|Vienna||Burgenland|Kaernten|Niederoesterreich|Oberoesterreich|Salzburg|Steiermark|Tirol|Vorarlberg|Wien';


city_states['Ireland'] = '|Dublin||Carlow|Cavan|Clare|Cork|Donegal|Galway|Kerry|Kildare|Kilkenny|Laois|Leitrim|Limerick|Longford|Louth|Mayo|Meath|Monaghan|Offaly|Roscommon|Sligo|Tipperary|Waterford|Westmeath|Wexford|Wicklow';


city_states['Finland'] = '|Helsinki||Aland|Etela-Suomen Laani|Ita-Suomen Laani|Lansi-Suomen Laani|Lappi|Oulun Laani';


city_states['Norway'] = '|Oslo||Akershus|Aust-Agder|Buskerud|Finnmark|Hedmark|Hordaland|More og Romsdal|Nordland|Nord-Trondelag|Oppland|Ostfold|Rogaland|Sogn og Fjordane|Sor-Trondelag|Telemark|Troms|Vest-Agder|Vestfold';


city_states['Malta'] = '|Gudja';


city_states['Croatia'] = '|Zagreb||Bjelovarsko-Bilogorska|Brodsko-Posavska|Dubrovacko-Neretvanska|Istarska|Karlovacka|Koprivnicko-Krizevacka|Krapinsko-Zagorska|Licko-Senjska|Medimurska|Osjecko-Baranjska|Pozesko-Slavonska|Primorsko-Goranska|Sibensko-Kninska|Sisacko-Moslavacka|Splitsko-Dalmatinska|Varazdinska|Viroviticko-Podravska|Vukovarsko-Srijemska|Zadarska|Zagrebacka';


city_states['Lithuania'] = '|Kaunas|Vilnius||Alytaus|Kauno|Klaipedos|Marijampoles|Panevezio|Siauliu|Taurages|Telsiu|Utenos';


city_states['Luxembourg'] = '|Sandweiler|Luxembourg||Diekirch|Grevenmacher';


city_states['Netherlands'] = '|Amsterdam|The Hague||Drenthe|Flevoland|Friesland|Gelderland|Groningen|Limburg|Noord-Brabant|Noord-Holland|Overijssel|Utrecht|Zeeland|Zuid-Holland';


city_states['Albania'] = '|Tirana||Berat|Bulqize|Delvine|Devoll|Diber|Durres|Elbasan|Fier|Gjirokaster|Gramsh|Has|Kavaje|Kolonje|Korce|Kruje|Kucove|Kukes|Kurbin|Lezhe|Librazhd|Lushnje|Malesi e Madhe|Mallakaster|Mat|Mirdite|Peqin|Permet|Pogradec|Puke|Sarande|Shkoder|Skrapar|Tepelene|Tirane|Tropoje|Vlore';

// ////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////

function setRegions(id) {
    var countryArr;
    var city_stateArr;
    var op = (id == "from") ? "myUL" : "myUL2";
    for (region in countries) {
        if (countries[region]) {
            countryArr = countries[region].split('|');
            for (var i = 0; i < countryArr.length; i++) {
                if (city_states[countryArr[i]]) {
                    city_stateArr = city_states[countryArr[i]].split('|');
                    for (var j = 0; j < city_stateArr.length; j++)
                        if (city_stateArr[j])
                            document.write('<li><a onclick="fofo(this, \'' + id + '\',\'' + op + '\' )"value="' + city_stateArr[j] + '" class="input"  >' + city_stateArr[j] + '\n <h4> ' + countryArr[i] + '</h4> </a></li>');
                }
            }
        }
    }
}

function myFunction(string, sae) {
    document.getElementById(sae).hidden = false;
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById(string);
    filter = input.value.toUpperCase();
    ul = document.getElementById(sae);
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

// function hiddes(){
// 	document.getElementById("").
// }
function fofo(elem, id, str) {
    console.log(elem.textContent);
    var spl = elem.textContent.split("\n");
    document.getElementById(id).value = spl[0];
    document.getElementById(str).hidden = true;
}

