package eu.hansolo.framer;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Optional;

import static eu.hansolo.toolbox.Constants.COLON;
import static eu.hansolo.toolbox.Constants.COMMA;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_CLOSE;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_OPEN;
import static eu.hansolo.toolbox.Constants.QUOTES;


public enum ZoneID {
    AFRICA_ABIDJAN("Africa/Abidjan","africa_abidjan","+00:00"),
    AFRICA_ACCRA("Africa/Accra","africa_accra","+00:00"),
    AFRICA_ADDIS_ABABA("Africa/Addis_Ababa","africa_addis_ababa","+03:00"),
    AFRICA_ALGIERS("Africa/Algiers","africa_algiers","+01:00"),
    AFRICA_ASMARA("Africa/Asmara","africa_asmara","+03:00"),
    AFRICA_ASMERA("Africa/Asmera","africa_asmera","+03:00"),
    AFRICA_BAMAKO("Africa/Bamako","africa_bamako","+00:00"),
    AFRICA_BANGUI("Africa/Bangui","africa_bangui","+01:00"),
    AFRICA_BANJUL("Africa/Banjul","africa_banjul","+00:00"),
    AFRICA_BISSAU("Africa/Bissau","africa_bissau","+00:00"),
    AFRICA_BLANTYRE("Africa/Blantyre","africa_blantyre","+02:00"),
    AFRICA_BRAZZAVILLE("Africa/Brazzaville","africa_brazzaville","+01:00"),
    AFRICA_BUJUMBURA("Africa/Bujumbura","africa_bujumbura","+02:00"),
    AFRICA_CAIRO("Africa/Cairo","africa_cairo","+02:00"),
    AFRICA_CASABLANCA("Africa/Casablanca","africa_casablanca","+01:00"),
    AFRICA_CEUTA("Africa/Ceuta","africa_ceuta","+01:00"),
    AFRICA_CONAKRY("Africa/Conakry","africa_conakry","+00:00"),
    AFRICA_DAKAR("Africa/Dakar","africa_dakar","+00:00"),
    AFRICA_DAR_ES_SALAAM("Africa/Dar_es_Salaam","africa_dar_es_salaam","+03:00"),
    AFRICA_DJIBOUTI("Africa/Djibouti","africa_djibouti","+03:00"),
    AFRICA_DOUALA("Africa/Douala","africa_douala","+01:00"),
    AFRICA_EL_AAIUN("Africa/El_Aaiun","africa_el_aaiun","+01:00"),
    AFRICA_FREETOWN("Africa/Freetown","africa_freetown","+00:00"),
    AFRICA_GABORONE("Africa/Gaborone","africa_gaborone","+02:00"),
    AFRICA_HARARE("Africa/Harare","africa_harare","+02:00"),
    AFRICA_JOHANNESBURG("Africa/Johannesburg","africa_johannesburg","+02:00"),
    AFRICA_JUBA("Africa/Juba","africa_juba","+02:00"),
    AFRICA_KAMPALA("Africa/Kampala","africa_kampala","+03:00"),
    AFRICA_KHARTOUM("Africa/Khartoum","africa_khartoum","+02:00"),
    AFRICA_KIGALI("Africa/Kigali","africa_kigali","+02:00"),
    AFRICA_KINSHASA("Africa/Kinshasa","africa_kinshasa","+01:00"),
    AFRICA_LAGOS("Africa/Lagos","africa_lagos","+01:00"),
    AFRICA_LIBREVILLE("Africa/Libreville","africa_libreville","+01:00"),
    AFRICA_LOME("Africa/Lome","africa_lome","+00:00"),
    AFRICA_LUANDA("Africa/Luanda","africa_luanda","+01:00"),
    AFRICA_LUBUMBASHI("Africa/Lubumbashi","africa_lubumbashi","+02:00"),
    AFRICA_LUSAKA("Africa/Lusaka","africa_lusaka","+02:00"),
    AFRICA_MALABO("Africa/Malabo","africa_malabo","+01:00"),
    AFRICA_MAPUTO("Africa/Maputo","africa_maputo","+02:00"),
    AFRICA_MASERU("Africa/Maseru","africa_maseru","+02:00"),
    AFRICA_MBABANE("Africa/Mbabane","africa_mbabane","+02:00"),
    AFRICA_MOGADISHU("Africa/Mogadishu","africa_mogadishu","+03:00"),
    AFRICA_MONROVIA("Africa/Monrovia","africa_monrovia","+00:00"),
    AFRICA_NAIROBI("Africa/Nairobi","africa_nairobi","+03:00"),
    AFRICA_NDJAMENA("Africa/Ndjamena","africa_ndjamena","+01:00"),
    AFRICA_NIAMEY("Africa/Niamey","africa_niamey","+01:00"),
    AFRICA_NOUAKCHOTT("Africa/Nouakchott","africa_nouakchott","+00:00"),
    AFRICA_OUAGADOUGOU("Africa/Ouagadougou","africa_ouagadougou","+00:00"),
    AFRICA_PORTO_NOVO("Africa/Porto-Novo","africa_porto-novo","+01:00"),
    AFRICA_SAO_TOME("Africa/Sao_Tome","africa_sao_tome","+00:00"),
    AFRICA_TIMBUKTU("Africa/Timbuktu","africa_timbuktu","+00:00"),
    AFRICA_TRIPOLI("Africa/Tripoli","africa_tripoli","+02:00"),
    AFRICA_TUNIS("Africa/Tunis","africa_tunis","+01:00"),
    AFRICA_WINDHOEK("Africa/Windhoek","africa_windhoek","+02:00"),
    AMERICA_ADAK("America/Adak","america_adak","-10:00"),
    AMERICA_ANCHORAGE("America/Anchorage","america_anchorage","-09:00"),
    AMERICA_ANGUILLA("America/Anguilla","america_anguilla","-04:00"),
    AMERICA_ANTIGUA("America/Antigua","america_antigua","-04:00"),
    AMERICA_ARAGUAINA("America/Araguaina","america_araguaina","-03:00"),
    AMERICA_ARGENTINA_BUENOS_AIRES("America/Argentina/Buenos_Aires","america_argentina_buenos_aires","-03:00"),
    AMERICA_ARGENTINA_CATAMARCA("America/Argentina/Catamarca","america_argentina_catamarca","-03:00"),
    AMERICA_ARGENTINA_COMODRIVADAVIA("America/Argentina/ComodRivadavia","america_argentina_comodrivadavia","-03:00"),
    AMERICA_ARGENTINA_CORDOBA("America/Argentina/Cordoba","america_argentina_cordoba","-03:00"),
    AMERICA_ARGENTINA_JUJUY("America/Argentina/Jujuy","america_argentina_jujuy","-03:00"),
    AMERICA_ARGENTINA_LA_RIOJA("America/Argentina/La_Rioja","america_argentina_la_rioja","-03:00"),
    AMERICA_ARGENTINA_MENDOZA("America/Argentina/Mendoza","america_argentina_mendoza","-03:00"),
    AMERICA_ARGENTINA_RIO_GALLEGOS("America/Argentina/Rio_Gallegos","america_argentina_rio_gallegos","-03:00"),
    AMERICA_ARGENTINA_SALTA("America/Argentina/Salta","america_argentina_salta","-03:00"),
    AMERICA_ARGENTINA_SAN_JUAN("America/Argentina/San_Juan","america_argentina_san_juan","-03:00"),
    AMERICA_ARGENTINA_SAN_LUIS("America/Argentina/San_Luis","america_argentina_san_luis","-03:00"),
    AMERICA_ARGENTINA_TUCUMAN("America/Argentina/Tucuman","america_argentina_tucuman","-03:00"),
    AMERICA_ARGENTINA_USHUAIA("America/Argentina/Ushuaia","america_argentina_ushuaia","-03:00"),
    AMERICA_ARUBA("America/Aruba","america_aruba","-04:00"),
    AMERICA_ASUNCION("America/Asuncion","america_asuncion","-03:00"),
    AMERICA_ATIKOKAN("America/Atikokan","america_atikokan","-05:00"),
    AMERICA_ATKA("America/Atka","america_atka","-10:00"),
    AMERICA_BAHIA("America/Bahia","america_bahia","-03:00"),
    AMERICA_BAHIA_BANDERAS("America/Bahia_Banderas","america_bahia_banderas","-06:00"),
    AMERICA_BARBADOS("America/Barbados","america_barbados","-04:00"),
    AMERICA_BELEM("America/Belem","america_belem","-03:00"),
    AMERICA_BELIZE("America/Belize","america_belize","-06:00"),
    AMERICA_BLANC_SABLON("America/Blanc-Sablon","america_blanc-sablon","-04:00"),
    AMERICA_BOA_VISTA("America/Boa_Vista","america_boa_vista","-04:00"),
    AMERICA_BOGOTA("America/Bogota","america_bogota","-05:00"),
    AMERICA_BOISE("America/Boise","america_boise","-07:00"),
    AMERICA_BUENOS_AIRES("America/Buenos_Aires","america_buenos_aires","-03:00"),
    AMERICA_CAMBRIDGE_BAY("America/Cambridge_Bay","america_cambridge_bay","-07:00"),
    AMERICA_CAMPO_GRANDE("America/Campo_Grande","america_campo_grande","-04:00"),
    AMERICA_CANCUN("America/Cancun","america_cancun","-05:00"),
    AMERICA_CARACAS("America/Caracas","america_caracas","-04:00"),
    AMERICA_CATAMARCA("America/Catamarca","america_catamarca","-03:00"),
    AMERICA_CAYENNE("America/Cayenne","america_cayenne","-03:00"),
    AMERICA_CAYMAN("America/Cayman","america_cayman","-05:00"),
    AMERICA_CHICAGO("America/Chicago","america_chicago","-06:00"),
    AMERICA_CHIHUAHUA("America/Chihuahua","america_chihuahua","-06:00"),
    AMERICA_CIUDAD_JUAREZ("America/Ciudad_Juarez","america_ciudad_juarez","-07:00"),
    AMERICA_CORAL_HARBOUR("America/Coral_Harbour","america_coral_harbour","-05:00"),
    AMERICA_CORDOBA("America/Cordoba","america_cordoba","-03:00"),
    AMERICA_COSTA_RICA("America/Costa_Rica","america_costa_rica","-06:00"),
    AMERICA_CRESTON("America/Creston","america_creston","-07:00"),
    AMERICA_CUIABA("America/Cuiaba","america_cuiaba","-04:00"),
    AMERICA_CURACAO("America/Curacao","america_curacao","-04:00"),
    AMERICA_DANMARKSHAVN("America/Danmarkshavn","america_danmarkshavn","+00:00"),
    AMERICA_DAWSON("America/Dawson","america_dawson","-07:00"),
    AMERICA_DAWSON_CREEK("America/Dawson_Creek","america_dawson_creek","-07:00"),
    AMERICA_DENVER("America/Denver","america_denver","-07:00"),
    AMERICA_DETROIT("America/Detroit","america_detroit","-05:00"),
    AMERICA_DOMINICA("America/Dominica","america_dominica","-04:00"),
    AMERICA_EDMONTON("America/Edmonton","america_edmonton","-07:00"),
    AMERICA_EIRUNEPE("America/Eirunepe","america_eirunepe","-05:00"),
    AMERICA_EL_SALVADOR("America/El_Salvador","america_el_salvador","-06:00"),
    AMERICA_ENSENADA("America/Ensenada","america_ensenada","-08:00"),
    AMERICA_FORT_NELSON("America/Fort_Nelson","america_fort_nelson","-07:00"),
    AMERICA_FORT_WAYNE("America/Fort_Wayne","america_fort_wayne","-05:00"),
    AMERICA_FORTALEZA("America/Fortaleza","america_fortaleza","-03:00"),
    AMERICA_GLACE_BAY("America/Glace_Bay","america_glace_bay","-04:00"),
    AMERICA_GODTHAB("America/Godthab","america_godthab","-03:00"),
    AMERICA_GOOSE_BAY("America/Goose_Bay","america_goose_bay","-04:00"),
    AMERICA_GRAND_TURK("America/Grand_Turk","america_grand_turk","-05:00"),
    AMERICA_GRENADA("America/Grenada","america_grenada","-04:00"),
    AMERICA_GUADELOUPE("America/Guadeloupe","america_guadeloupe","-04:00"),
    AMERICA_GUATEMALA("America/Guatemala","america_guatemala","-06:00"),
    AMERICA_GUAYAQUIL("America/Guayaquil","america_guayaquil","-05:00"),
    AMERICA_GUYANA("America/Guyana","america_guyana","-04:00"),
    AMERICA_HALIFAX("America/Halifax","america_halifax","-04:00"),
    AMERICA_HAVANA("America/Havana","america_havana","-05:00"),
    AMERICA_HERMOSILLO("America/Hermosillo","america_hermosillo","-07:00"),
    AMERICA_INDIANA_INDIANAPOLIS("America/Indiana/Indianapolis","america_indiana_indianapolis","-05:00"),
    AMERICA_INDIANA_KNOX("America/Indiana/Knox","america_indiana_knox","-06:00"),
    AMERICA_INDIANA_MARENGO("America/Indiana/Marengo","america_indiana_marengo","-05:00"),
    AMERICA_INDIANA_PETERSBURG("America/Indiana/Petersburg","america_indiana_petersburg","-05:00"),
    AMERICA_INDIANA_TELL_CITY("America/Indiana/Tell_City","america_indiana_tell_city","-06:00"),
    AMERICA_INDIANA_VEVAY("America/Indiana/Vevay","america_indiana_vevay","-05:00"),
    AMERICA_INDIANA_VINCENNES("America/Indiana/Vincennes","america_indiana_vincennes","-05:00"),
    AMERICA_INDIANA_WINAMAC("America/Indiana/Winamac","america_indiana_winamac","-05:00"),
    AMERICA_INDIANAPOLIS("America/Indianapolis","america_indianapolis","-05:00"),
    AMERICA_INUVIK("America/Inuvik","america_inuvik","-07:00"),
    AMERICA_IQALUIT("America/Iqaluit","america_iqaluit","-05:00"),
    AMERICA_JAMAICA("America/Jamaica","america_jamaica","-05:00"),
    AMERICA_JUJUY("America/Jujuy","america_jujuy","-03:00"),
    AMERICA_JUNEAU("America/Juneau","america_juneau","-09:00"),
    AMERICA_KENTUCKY_LOUISVILLE("America/Kentucky/Louisville","america_kentucky_louisville","-05:00"),
    AMERICA_KENTUCKY_MONTICELLO("America/Kentucky/Monticello","america_kentucky_monticello","-05:00"),
    AMERICA_KNOX_IN("America/Knox_IN","america_knox_in","-06:00"),
    AMERICA_KRALENDIJK("America/Kralendijk","america_kralendijk","-04:00"),
    AMERICA_LA_PAZ("America/La_Paz","america_la_paz","-04:00"),
    AMERICA_LIMA("America/Lima","america_lima","-05:00"),
    AMERICA_LOS_ANGELES("America/Los_Angeles","america_los_angeles","-08:00"),
    AMERICA_LOUISVILLE("America/Louisville","america_louisville","-05:00"),
    AMERICA_LOWER_PRINCES("America/Lower_Princes","america_lower_princes","-04:00"),
    AMERICA_MACEIO("America/Maceio","america_maceio","-03:00"),
    AMERICA_MANAGUA("America/Managua","america_managua","-06:00"),
    AMERICA_MANAUS("America/Manaus","america_manaus","-04:00"),
    AMERICA_MARIGOT("America/Marigot","america_marigot","-04:00"),
    AMERICA_MARTINIQUE("America/Martinique","america_martinique","-04:00"),
    AMERICA_MATAMOROS("America/Matamoros","america_matamoros","-06:00"),
    AMERICA_MAZATLAN("America/Mazatlan","america_mazatlan","-07:00"),
    AMERICA_MENDOZA("America/Mendoza","america_mendoza","-03:00"),
    AMERICA_MENOMINEE("America/Menominee","america_menominee","-06:00"),
    AMERICA_MERIDA("America/Merida","america_merida","-06:00"),
    AMERICA_METLAKATLA("America/Metlakatla","america_metlakatla","-09:00"),
    AMERICA_MEXICO_CITY("America/Mexico_City","america_mexico_city","-06:00"),
    AMERICA_MIQUELON("America/Miquelon","america_miquelon","-03:00"),
    AMERICA_MONCTON("America/Moncton","america_moncton","-04:00"),
    AMERICA_MONTERREY("America/Monterrey","america_monterrey","-06:00"),
    AMERICA_MONTEVIDEO("America/Montevideo","america_montevideo","-03:00"),
    AMERICA_MONTREAL("America/Montreal","america_montreal","-05:00"),
    AMERICA_MONTSERRAT("America/Montserrat","america_montserrat","-04:00"),
    AMERICA_NASSAU("America/Nassau","america_nassau","-05:00"),
    AMERICA_NEW_YORK("America/New_York","america_new_york","-05:00"),
    AMERICA_NIPIGON("America/Nipigon","america_nipigon","-05:00"),
    AMERICA_NOME("America/Nome","america_nome","-09:00"),
    AMERICA_NORONHA("America/Noronha","america_noronha","-02:00"),
    AMERICA_NORTH_DAKOTA_BEULAH("America/North_Dakota/Beulah","america_north_dakota_beulah","-06:00"),
    AMERICA_NORTH_DAKOTA_CENTER("America/North_Dakota/Center","america_north_dakota_center","-06:00"),
    AMERICA_NORTH_DAKOTA_NEW_SALEM("America/North_Dakota/New_Salem","america_north_dakota_new_salem","-06:00"),
    AMERICA_NUUK("America/Nuuk","america_nuuk","-03:00"),
    AMERICA_OJINAGA("America/Ojinaga","america_ojinaga","-06:00"),
    AMERICA_PANAMA("America/Panama","america_panama","-05:00"),
    AMERICA_PANGNIRTUNG("America/Pangnirtung","america_pangnirtung","-05:00"),
    AMERICA_PARAMARIBO("America/Paramaribo","america_paramaribo","-03:00"),
    AMERICA_PHOENIX("America/Phoenix","america_phoenix","-07:00"),
    AMERICA_PORT_AU_PRINCE("America/Port-au-Prince","america_port-au-prince","-05:00"),
    AMERICA_PORT_OF_SPAIN("America/Port_of_Spain","america_port_of_spain","-04:00"),
    AMERICA_PORTO_ACRE("America/Porto_Acre","america_porto_acre","-05:00"),
    AMERICA_PORTO_VELHO("America/Porto_Velho","america_porto_velho","-04:00"),
    AMERICA_PUERTO_RICO("America/Puerto_Rico","america_puerto_rico","-04:00"),
    AMERICA_PUNTA_ARENAS("America/Punta_Arenas","america_punta_arenas","-03:00"),
    AMERICA_RAINY_RIVER("America/Rainy_River","america_rainy_river","-06:00"),
    AMERICA_RANKIN_INLET("America/Rankin_Inlet","america_rankin_inlet","-06:00"),
    AMERICA_RECIFE("America/Recife","america_recife","-03:00"),
    AMERICA_REGINA("America/Regina","america_regina","-06:00"),
    AMERICA_RESOLUTE("America/Resolute","america_resolute","-06:00"),
    AMERICA_RIO_BRANCO("America/Rio_Branco","america_rio_branco","-05:00"),
    AMERICA_ROSARIO("America/Rosario","america_rosario","-03:00"),
    AMERICA_SANTA_ISABEL("America/Santa_Isabel","america_santa_isabel","-08:00"),
    AMERICA_SANTAREM("America/Santarem","america_santarem","-03:00"),
    AMERICA_SANTIAGO("America/Santiago","america_santiago","-03:00"),
    AMERICA_SANTO_DOMINGO("America/Santo_Domingo","america_santo_domingo","-04:00"),
    AMERICA_SAO_PAULO("America/Sao_Paulo","america_sao_paulo","-03:00"),
    AMERICA_SCORESBYSUND("America/Scoresbysund","america_scoresbysund","-01:00"),
    AMERICA_SHIPROCK("America/Shiprock","america_shiprock","-07:00"),
    AMERICA_SITKA("America/Sitka","america_sitka","-09:00"),
    AMERICA_ST_BARTHELEMY("America/St_Barthelemy","america_st_barthelemy","-04:00"),
    AMERICA_ST_JOHNS("America/St_Johns","america_st_johns","-03:30"),
    AMERICA_ST_KITTS("America/St_Kitts","america_st_kitts","-04:00"),
    AMERICA_ST_LUCIA("America/St_Lucia","america_st_lucia","-04:00"),
    AMERICA_ST_THOMAS("America/St_Thomas","america_st_thomas","-04:00"),
    AMERICA_ST_VINCENT("America/St_Vincent","america_st_vincent","-04:00"),
    AMERICA_SWIFT_CURRENT("America/Swift_Current","america_swift_current","-06:00"),
    AMERICA_TEGUCIGALPA("America/Tegucigalpa","america_tegucigalpa","-06:00"),
    AMERICA_THULE("America/Thule","america_thule","-04:00"),
    AMERICA_THUNDER_BAY("America/Thunder_Bay","america_thunder_bay","-05:00"),
    AMERICA_TIJUANA("America/Tijuana","america_tijuana","-08:00"),
    AMERICA_TORONTO("America/Toronto","america_toronto","-05:00"),
    AMERICA_TORTOLA("America/Tortola","america_tortola","-04:00"),
    AMERICA_VANCOUVER("America/Vancouver","america_vancouver","-08:00"),
    AMERICA_VIRGIN("America/Virgin","america_virgin","-04:00"),
    AMERICA_WHITEHORSE("America/Whitehorse","america_whitehorse","-07:00"),
    AMERICA_WINNIPEG("America/Winnipeg","america_winnipeg","-06:00"),
    AMERICA_YAKUTAT("America/Yakutat","america_yakutat","-09:00"),
    AMERICA_YELLOWKNIFE("America/Yellowknife","america_yellowknife","-07:00"),
    ANTARCTICA_CASEY("Antarctica/Casey","antarctica_casey","+11:00"),
    ANTARCTICA_DAVIS("Antarctica/Davis","antarctica_davis","+07:00"),
    ANTARCTICA_DUMONTDURVILLE("Antarctica/DumontDUrville","antarctica_dumontdurville","+10:00"),
    ANTARCTICA_MACQUARIE("Antarctica/Macquarie","antarctica_macquarie","+11:00"),
    ANTARCTICA_MAWSON("Antarctica/Mawson","antarctica_mawson","+05:00"),
    ANTARCTICA_MCMURDO("Antarctica/McMurdo","antarctica_mcmurdo","+13:00"),
    ANTARCTICA_PALMER("Antarctica/Palmer","antarctica_palmer","-03:00"),
    ANTARCTICA_ROTHERA("Antarctica/Rothera","antarctica_rothera","-03:00"),
    ANTARCTICA_SOUTH_POLE("Antarctica/South_Pole","antarctica_south_pole","+13:00"),
    ANTARCTICA_SYOWA("Antarctica/Syowa","antarctica_syowa","+03:00"),
    ANTARCTICA_TROLL("Antarctica/Troll","antarctica_troll","+00:00"),
    ANTARCTICA_VOSTOK("Antarctica/Vostok","antarctica_vostok","+06:00"),
    ARCTIC_LONGYEARBYEN("Arctic/Longyearbyen","arctic_longyearbyen","+01:00"),
    ASIA_ADEN("Asia/Aden","asia_aden","+03:00"),
    ASIA_ALMATY("Asia/Almaty","asia_almaty","+06:00"),
    ASIA_AMMAN("Asia/Amman","asia_amman","+03:00"),
    ASIA_ANADYR("Asia/Anadyr","asia_anadyr","+12:00"),
    ASIA_AQTAU("Asia/Aqtau","asia_aqtau","+05:00"),
    ASIA_AQTOBE("Asia/Aqtobe","asia_aqtobe","+05:00"),
    ASIA_ASHGABAT("Asia/Ashgabat","asia_ashgabat","+05:00"),
    ASIA_ASHKHABAD("Asia/Ashkhabad","asia_ashkhabad","+05:00"),
    ASIA_ATYRAU("Asia/Atyrau","asia_atyrau","+05:00"),
    ASIA_BAGHDAD("Asia/Baghdad","asia_baghdad","+03:00"),
    ASIA_BAHRAIN("Asia/Bahrain","asia_bahrain","+03:00"),
    ASIA_BAKU("Asia/Baku","asia_baku","+04:00"),
    ASIA_BANGKOK("Asia/Bangkok","asia_bangkok","+07:00"),
    ASIA_BARNAUL("Asia/Barnaul","asia_barnaul","+07:00"),
    ASIA_BEIRUT("Asia/Beirut","asia_beirut","+02:00"),
    ASIA_BISHKEK("Asia/Bishkek","asia_bishkek","+06:00"),
    ASIA_BRUNEI("Asia/Brunei","asia_brunei","+08:00"),
    ASIA_CALCUTTA("Asia/Calcutta","asia_calcutta","+05:30"),
    ASIA_CHITA("Asia/Chita","asia_chita","+09:00"),
    ASIA_CHOIBALSAN("Asia/Choibalsan","asia_choibalsan","+08:00"),
    ASIA_CHONGQING("Asia/Chongqing","asia_chongqing","+08:00"),
    ASIA_CHUNGKING("Asia/Chungking","asia_chungking","+08:00"),
    ASIA_COLOMBO("Asia/Colombo","asia_colombo","+05:30"),
    ASIA_DACCA("Asia/Dacca","asia_dacca","+06:00"),
    ASIA_DAMASCUS("Asia/Damascus","asia_damascus","+03:00"),
    ASIA_DHAKA("Asia/Dhaka","asia_dhaka","+06:00"),
    ASIA_DILI("Asia/Dili","asia_dili","+09:00"),
    ASIA_DUBAI("Asia/Dubai","asia_dubai","+04:00"),
    ASIA_DUSHANBE("Asia/Dushanbe","asia_dushanbe","+05:00"),
    ASIA_FAMAGUSTA("Asia/Famagusta","asia_famagusta","+02:00"),
    ASIA_GAZA("Asia/Gaza","asia_gaza","+02:00"),
    ASIA_HARBIN("Asia/Harbin","asia_harbin","+08:00"),
    ASIA_HEBRON("Asia/Hebron","asia_hebron","+02:00"),
    ASIA_HO_CHI_MINH("Asia/Ho_Chi_Minh","asia_ho_chi_minh","+07:00"),
    ASIA_HONG_KONG("Asia/Hong_Kong","asia_hong_kong","+08:00"),
    ASIA_HOVD("Asia/Hovd","asia_hovd","+07:00"),
    ASIA_IRKUTSK("Asia/Irkutsk","asia_irkutsk","+08:00"),
    ASIA_ISTANBUL("Asia/Istanbul","asia_istanbul","+03:00"),
    ASIA_JAKARTA("Asia/Jakarta","asia_jakarta","+07:00"),
    ASIA_JAYAPURA("Asia/Jayapura","asia_jayapura","+09:00"),
    ASIA_JERUSALEM("Asia/Jerusalem","asia_jerusalem","+02:00"),
    ASIA_KABUL("Asia/Kabul","asia_kabul","+04:30"),
    ASIA_KAMCHATKA("Asia/Kamchatka","asia_kamchatka","+12:00"),
    ASIA_KARACHI("Asia/Karachi","asia_karachi","+05:00"),
    ASIA_KASHGAR("Asia/Kashgar","asia_kashgar","+06:00"),
    ASIA_KATHMANDU("Asia/Kathmandu","asia_kathmandu","+05:45"),
    ASIA_KATMANDU("Asia/Katmandu","asia_katmandu","+05:45"),
    ASIA_KHANDYGA("Asia/Khandyga","asia_khandyga","+09:00"),
    ASIA_KOLKATA("Asia/Kolkata","asia_kolkata","+05:30"),
    ASIA_KRASNOYARSK("Asia/Krasnoyarsk","asia_krasnoyarsk","+07:00"),
    ASIA_KUALA_LUMPUR("Asia/Kuala_Lumpur","asia_kuala_lumpur","+08:00"),
    ASIA_KUCHING("Asia/Kuching","asia_kuching","+08:00"),
    ASIA_KUWAIT("Asia/Kuwait","asia_kuwait","+03:00"),
    ASIA_MACAO("Asia/Macao","asia_macao","+08:00"),
    ASIA_MACAU("Asia/Macau","asia_macau","+08:00"),
    ASIA_MAGADAN("Asia/Magadan","asia_magadan","+11:00"),
    ASIA_MAKASSAR("Asia/Makassar","asia_makassar","+08:00"),
    ASIA_MANILA("Asia/Manila","asia_manila","+08:00"),
    ASIA_MUSCAT("Asia/Muscat","asia_muscat","+04:00"),
    ASIA_NICOSIA("Asia/Nicosia","asia_nicosia","+02:00"),
    ASIA_NOVOKUZNETSK("Asia/Novokuznetsk","asia_novokuznetsk","+07:00"),
    ASIA_NOVOSIBIRSK("Asia/Novosibirsk","asia_novosibirsk","+07:00"),
    ASIA_OMSK("Asia/Omsk","asia_omsk","+06:00"),
    ASIA_ORAL("Asia/Oral","asia_oral","+05:00"),
    ASIA_PHNOM_PENH("Asia/Phnom_Penh","asia_phnom_penh","+07:00"),
    ASIA_PONTIANAK("Asia/Pontianak","asia_pontianak","+07:00"),
    ASIA_PYONGYANG("Asia/Pyongyang","asia_pyongyang","+09:00"),
    ASIA_QATAR("Asia/Qatar","asia_qatar","+03:00"),
    ASIA_QOSTANAY("Asia/Qostanay","asia_qostanay","+06:00"),
    ASIA_QYZYLORDA("Asia/Qyzylorda","asia_qyzylorda","+05:00"),
    ASIA_RANGOON("Asia/Rangoon","asia_rangoon","+06:30"),
    ASIA_RIYADH("Asia/Riyadh","asia_riyadh","+03:00"),
    ASIA_SAIGON("Asia/Saigon","asia_saigon","+07:00"),
    ASIA_SAKHALIN("Asia/Sakhalin","asia_sakhalin","+11:00"),
    ASIA_SAMARKAND("Asia/Samarkand","asia_samarkand","+05:00"),
    ASIA_SEOUL("Asia/Seoul","asia_seoul","+09:00"),
    ASIA_SHANGHAI("Asia/Shanghai","asia_shanghai","+08:00"),
    ASIA_SINGAPORE("Asia/Singapore","asia_singapore","+08:00"),
    ASIA_SREDNEKOLYMSK("Asia/Srednekolymsk","asia_srednekolymsk","+11:00"),
    ASIA_TAIPEI("Asia/Taipei","asia_taipei","+08:00"),
    ASIA_TASHKENT("Asia/Tashkent","asia_tashkent","+05:00"),
    ASIA_TBILISI("Asia/Tbilisi","asia_tbilisi","+04:00"),
    ASIA_TEHRAN("Asia/Tehran","asia_tehran","+03:30"),
    ASIA_TEL_AVIV("Asia/Tel_Aviv","asia_tel_aviv","+02:00"),
    ASIA_THIMBU("Asia/Thimbu","asia_thimbu","+06:00"),
    ASIA_THIMPHU("Asia/Thimphu","asia_thimphu","+06:00"),
    ASIA_TOKYO("Asia/Tokyo","asia_tokyo","+09:00"),
    ASIA_TOMSK("Asia/Tomsk","asia_tomsk","+07:00"),
    ASIA_UJUNG_PANDANG("Asia/Ujung_Pandang","asia_ujung_pandang","+08:00"),
    ASIA_ULAANBAATAR("Asia/Ulaanbaatar","asia_ulaanbaatar","+08:00"),
    ASIA_ULAN_BATOR("Asia/Ulan_Bator","asia_ulan_bator","+08:00"),
    ASIA_URUMQI("Asia/Urumqi","asia_urumqi","+06:00"),
    ASIA_UST_NERA("Asia/Ust-Nera","asia_ust-nera","+10:00"),
    ASIA_VIENTIANE("Asia/Vientiane","asia_vientiane","+07:00"),
    ASIA_VLADIVOSTOK("Asia/Vladivostok","asia_vladivostok","+10:00"),
    ASIA_YAKUTSK("Asia/Yakutsk","asia_yakutsk","+09:00"),
    ASIA_YANGON("Asia/Yangon","asia_yangon","+06:30"),
    ASIA_YEKATERINBURG("Asia/Yekaterinburg","asia_yekaterinburg","+05:00"),
    ASIA_YEREVAN("Asia/Yerevan","asia_yerevan","+04:00"),
    ATLANTIC_AZORES("Atlantic/Azores","atlantic_azores","-01:00"),
    ATLANTIC_BERMUDA("Atlantic/Bermuda","atlantic_bermuda","-04:00"),
    ATLANTIC_CANARY("Atlantic/Canary","atlantic_canary","+00:00"),
    ATLANTIC_CAPE_VERDE("Atlantic/Cape_Verde","atlantic_cape_verde","-01:00"),
    ATLANTIC_FAEROE("Atlantic/Faeroe","atlantic_faeroe","+00:00"),
    ATLANTIC_FAROE("Atlantic/Faroe","atlantic_faroe","+00:00"),
    ATLANTIC_JAN_MAYEN("Atlantic/Jan_Mayen","atlantic_jan_mayen","+01:00"),
    ATLANTIC_MADEIRA("Atlantic/Madeira","atlantic_madeira","+00:00"),
    ATLANTIC_REYKJAVIK("Atlantic/Reykjavik","atlantic_reykjavik","+00:00"),
    ATLANTIC_SOUTH_GEORGIA("Atlantic/South_Georgia","atlantic_south_georgia","-02:00"),
    ATLANTIC_ST_HELENA("Atlantic/St_Helena","atlantic_st_helena","+00:00"),
    ATLANTIC_STANLEY("Atlantic/Stanley","atlantic_stanley","-03:00"),
    AUSTRALIA_ACT("Australia/ACT","australia_act","+11:00"),
    AUSTRALIA_ADELAIDE("Australia/Adelaide","australia_adelaide","+10:30"),
    AUSTRALIA_BRISBANE("Australia/Brisbane","australia_brisbane","+10:00"),
    AUSTRALIA_BROKEN_HILL("Australia/Broken_Hill","australia_broken_hill","+10:30"),
    AUSTRALIA_CANBERRA("Australia/Canberra","australia_canberra","+11:00"),
    AUSTRALIA_CURRIE("Australia/Currie","australia_currie","+11:00"),
    AUSTRALIA_DARWIN("Australia/Darwin","australia_darwin","+09:30"),
    AUSTRALIA_EUCLA("Australia/Eucla","australia_eucla","+08:45"),
    AUSTRALIA_HOBART("Australia/Hobart","australia_hobart","+11:00"),
    AUSTRALIA_LHI("Australia/LHI","australia_lhi","+11:00"),
    AUSTRALIA_LINDEMAN("Australia/Lindeman","australia_lindeman","+10:00"),
    AUSTRALIA_LORD_HOWE("Australia/Lord_Howe","australia_lord_howe","+11:00"),
    AUSTRALIA_MELBOURNE("Australia/Melbourne","australia_melbourne","+11:00"),
    AUSTRALIA_NSW("Australia/NSW","australia_nsw","+11:00"),
    AUSTRALIA_NORTH("Australia/North","australia_north","+09:30"),
    AUSTRALIA_PERTH("Australia/Perth","australia_perth","+08:00"),
    AUSTRALIA_QUEENSLAND("Australia/Queensland","australia_queensland","+10:00"),
    AUSTRALIA_SOUTH("Australia/South","australia_south","+10:30"),
    AUSTRALIA_SYDNEY("Australia/Sydney","australia_sydney","+11:00"),
    AUSTRALIA_TASMANIA("Australia/Tasmania","australia_tasmania","+11:00"),
    AUSTRALIA_VICTORIA("Australia/Victoria","australia_victoria","+11:00"),
    AUSTRALIA_WEST("Australia/West","australia_west","+08:00"),
    AUSTRALIA_YANCOWINNA("Australia/Yancowinna","australia_yancowinna","+10:30"),
    BRAZIL_ACRE("Brazil/Acre","brazil_acre","-05:00"),
    BRAZIL_DENORONHA("Brazil/DeNoronha","brazil_denoronha","-02:00"),
    BRAZIL_EAST("Brazil/East","brazil_east","-03:00"),
    BRAZIL_WEST("Brazil/West","brazil_west","-04:00"),
    CET("CET","cet","+01:00"),
    CST6CDT("CST6CDT","cst6cdt","-06:00"),
    CANADA_ATLANTIC("Canada/Atlantic","canada_atlantic","-04:00"),
    CANADA_CENTRAL("Canada/Central","canada_central","-06:00"),
    CANADA_EASTERN("Canada/Eastern","canada_eastern","-05:00"),
    CANADA_MOUNTAIN("Canada/Mountain","canada_mountain","-07:00"),
    CANADA_NEWFOUNDLAND("Canada/Newfoundland","canada_newfoundland","-03:30"),
    CANADA_PACIFIC("Canada/Pacific","canada_pacific","-08:00"),
    CANADA_SASKATCHEWAN("Canada/Saskatchewan","canada_saskatchewan","-06:00"),
    CANADA_YUKON("Canada/Yukon","canada_yukon","-07:00"),
    CHILE_CONTINENTAL("Chile/Continental","chile_continental","-03:00"),
    CHILE_EASTERISLAND("Chile/EasterIsland","chile_easterisland","-05:00"),
    CUBA("Cuba","cuba","-05:00"),
    EET("EET","eet","+02:00"),
    EST5EDT("EST5EDT","est5edt","-05:00"),
    EGYPT("Egypt","egypt","+02:00"),
    EIRE("Eire","eire","+00:00"),
    ETC_GMT("Etc/GMT","etc_gmt","+00:00"),
    ETC_GMT_PLUS_0("Etc/GMT+0","etc_gmt+0","+00:00"),
    ETC_GMT_PLUS_1("Etc/GMT+1","etc_gmt+1","-01:00"),
    ETC_GMT_PLUS_10("Etc/GMT+10","etc_gmt+10","-10:00"),
    ETC_GMT_PLUS_11("Etc/GMT+11","etc_gmt+11","-11:00"),
    ETC_GMT_PLUS_12("Etc/GMT+12","etc_gmt+12","-12:00"),
    ETC_GMT_PLUS_2("Etc/GMT+2","etc_gmt+2","-02:00"),
    ETC_GMT_PLUS_3("Etc/GMT+3","etc_gmt+3","-03:00"),
    ETC_GMT_PLUS_4("Etc/GMT+4","etc_gmt+4","-04:00"),
    ETC_GMT_PLUS_5("Etc/GMT+5","etc_gmt+5","-05:00"),
    ETC_GMT_PLUS_6("Etc/GMT+6","etc_gmt+6","-06:00"),
    ETC_GMT_PLUS_7("Etc/GMT+7","etc_gmt+7","-07:00"),
    ETC_GMT_PLUS_8("Etc/GMT+8","etc_gmt+8","-08:00"),
    ETC_GMT_PLUS_9("Etc/GMT+9","etc_gmt+9","-09:00"),
    ETC_GMT_MINUS_0("Etc/GMT-0","etc_gmt-0","+00:00"),
    ETC_GMT_MINUS_1("Etc/GMT-1","etc_gmt-1","+01:00"),
    ETC_GMT_MINUS_10("Etc/GMT-10","etc_gmt-10","+10:00"),
    ETC_GMT_MINUS_11("Etc/GMT-11","etc_gmt-11","+11:00"),
    ETC_GMT_MINUS_12("Etc/GMT-12","etc_gmt-12","+12:00"),
    ETC_GMT_MINUS_13("Etc/GMT-13","etc_gmt-13","+13:00"),
    ETC_GMT_MINUS_14("Etc/GMT-14","etc_gmt-14","+14:00"),
    ETC_GMT_MINUS_2("Etc/GMT-2","etc_gmt-2","+02:00"),
    ETC_GMT_MINUS_3("Etc/GMT-3","etc_gmt-3","+03:00"),
    ETC_GMT_MINUS_4("Etc/GMT-4","etc_gmt-4","+04:00"),
    ETC_GMT_MINUS_5("Etc/GMT-5","etc_gmt-5","+05:00"),
    ETC_GMT_MINUS_6("Etc/GMT-6","etc_gmt-6","+06:00"),
    ETC_GMT_MINUS_7("Etc/GMT-7","etc_gmt-7","+07:00"),
    ETC_GMT_MINUS_8("Etc/GMT-8","etc_gmt-8","+08:00"),
    ETC_GMT_MINUS_9("Etc/GMT-9","etc_gmt-9","+09:00"),
    ETC_GMT0("Etc/GMT0","etc_gmt0","+00:00"),
    ETC_GREENWICH("Etc/Greenwich","etc_greenwich","+00:00"),
    ETC_UCT("Etc/UCT","etc_uct","+00:00"),
    ETC_UTC("Etc/UTC","etc_utc","+00:00"),
    ETC_UNIVERSAL("Etc/Universal","etc_universal","+00:00"),
    ETC_ZULU("Etc/Zulu","etc_zulu","+00:00"),
    EUROPE_AMSTERDAM("Europe/Amsterdam","europe_amsterdam","+01:00"),
    EUROPE_ANDORRA("Europe/Andorra","europe_andorra","+01:00"),
    EUROPE_ASTRAKHAN("Europe/Astrakhan","europe_astrakhan","+04:00"),
    EUROPE_ATHENS("Europe/Athens","europe_athens","+02:00"),
    EUROPE_BELFAST("Europe/Belfast","europe_belfast","+00:00"),
    EUROPE_BELGRADE("Europe/Belgrade","europe_belgrade","+01:00"),
    EUROPE_BERLIN("Europe/Berlin","europe_berlin","+01:00"),
    EUROPE_BRATISLAVA("Europe/Bratislava","europe_bratislava","+01:00"),
    EUROPE_BRUSSELS("Europe/Brussels","europe_brussels","+01:00"),
    EUROPE_BUCHAREST("Europe/Bucharest","europe_bucharest","+02:00"),
    EUROPE_BUDAPEST("Europe/Budapest","europe_budapest","+01:00"),
    EUROPE_BUSINGEN("Europe/Busingen","europe_busingen","+01:00"),
    EUROPE_CHISINAU("Europe/Chisinau","europe_chisinau","+02:00"),
    EUROPE_COPENHAGEN("Europe/Copenhagen","europe_copenhagen","+01:00"),
    EUROPE_DUBLIN("Europe/Dublin","europe_dublin","+00:00"),
    EUROPE_GIBRALTAR("Europe/Gibraltar","europe_gibraltar","+01:00"),
    EUROPE_GUERNSEY("Europe/Guernsey","europe_guernsey","+00:00"),
    EUROPE_HELSINKI("Europe/Helsinki","europe_helsinki","+02:00"),
    EUROPE_ISLE_OF_MAN("Europe/Isle_of_Man","europe_isle_of_man","+00:00"),
    EUROPE_ISTANBUL("Europe/Istanbul","europe_istanbul","+03:00"),
    EUROPE_JERSEY("Europe/Jersey","europe_jersey","+00:00"),
    EUROPE_KALININGRAD("Europe/Kaliningrad","europe_kaliningrad","+02:00"),
    EUROPE_KIEV("Europe/Kiev","europe_kiev","+02:00"),
    EUROPE_KIROV("Europe/Kirov","europe_kirov","+03:00"),
    EUROPE_KYIV("Europe/Kyiv","europe_kyiv","+02:00"),
    EUROPE_LISBON("Europe/Lisbon","europe_lisbon","+00:00"),
    EUROPE_LJUBLJANA("Europe/Ljubljana","europe_ljubljana","+01:00"),
    EUROPE_LONDON("Europe/London","europe_london","+00:00"),
    EUROPE_LUXEMBOURG("Europe/Luxembourg","europe_luxembourg","+01:00"),
    EUROPE_MADRID("Europe/Madrid","europe_madrid","+01:00"),
    EUROPE_MALTA("Europe/Malta","europe_malta","+01:00"),
    EUROPE_MARIEHAMN("Europe/Mariehamn","europe_mariehamn","+02:00"),
    EUROPE_MINSK("Europe/Minsk","europe_minsk","+03:00"),
    EUROPE_MONACO("Europe/Monaco","europe_monaco","+01:00"),
    EUROPE_MOSCOW("Europe/Moscow","europe_moscow","+03:00"),
    EUROPE_NICOSIA("Europe/Nicosia","europe_nicosia","+02:00"),
    EUROPE_OSLO("Europe/Oslo","europe_oslo","+01:00"),
    EUROPE_PARIS("Europe/Paris","europe_paris","+01:00"),
    EUROPE_PODGORICA("Europe/Podgorica","europe_podgorica","+01:00"),
    EUROPE_PRAGUE("Europe/Prague","europe_prague","+01:00"),
    EUROPE_RIGA("Europe/Riga","europe_riga","+02:00"),
    EUROPE_ROME("Europe/Rome","europe_rome","+01:00"),
    EUROPE_SAMARA("Europe/Samara","europe_samara","+04:00"),
    EUROPE_SAN_MARINO("Europe/San_Marino","europe_san_marino","+01:00"),
    EUROPE_SARAJEVO("Europe/Sarajevo","europe_sarajevo","+01:00"),
    EUROPE_SARATOV("Europe/Saratov","europe_saratov","+04:00"),
    EUROPE_SIMFEROPOL("Europe/Simferopol","europe_simferopol","+03:00"),
    EUROPE_SKOPJE("Europe/Skopje","europe_skopje","+01:00"),
    EUROPE_SOFIA("Europe/Sofia","europe_sofia","+02:00"),
    EUROPE_STOCKHOLM("Europe/Stockholm","europe_stockholm","+01:00"),
    EUROPE_TALLINN("Europe/Tallinn","europe_tallinn","+02:00"),
    EUROPE_TIRANE("Europe/Tirane","europe_tirane","+01:00"),
    EUROPE_TIRASPOL("Europe/Tiraspol","europe_tiraspol","+02:00"),
    EUROPE_ULYANOVSK("Europe/Ulyanovsk","europe_ulyanovsk","+04:00"),
    EUROPE_UZHGOROD("Europe/Uzhgorod","europe_uzhgorod","+02:00"),
    EUROPE_VADUZ("Europe/Vaduz","europe_vaduz","+01:00"),
    EUROPE_VATICAN("Europe/Vatican","europe_vatican","+01:00"),
    EUROPE_VIENNA("Europe/Vienna","europe_vienna","+01:00"),
    EUROPE_VILNIUS("Europe/Vilnius","europe_vilnius","+02:00"),
    EUROPE_VOLGOGRAD("Europe/Volgograd","europe_volgograd","+03:00"),
    EUROPE_WARSAW("Europe/Warsaw","europe_warsaw","+01:00"),
    EUROPE_ZAGREB("Europe/Zagreb","europe_zagreb","+01:00"),
    EUROPE_ZAPOROZHYE("Europe/Zaporozhye","europe_zaporozhye","+02:00"),
    EUROPE_ZURICH("Europe/Zurich","europe_zurich","+01:00"),
    GB("GB","gb","+00:00"),
    GB_EIRE("GB-Eire","gb-eire","+00:00"),
    GMT("GMT","gmt","+00:00"),
    GMT0("GMT0","gmt0","+00:00"),
    GREENWICH("Greenwich","greenwich","+00:00"),
    HONGKONG("Hongkong","hongkong","+08:00"),
    ICELAND("Iceland","iceland","+00:00"),
    INDIAN_ANTANANARIVO("Indian/Antananarivo","indian_antananarivo","+03:00"),
    INDIAN_CHAGOS("Indian/Chagos","indian_chagos","+06:00"),
    INDIAN_CHRISTMAS("Indian/Christmas","indian_christmas","+07:00"),
    INDIAN_COCOS("Indian/Cocos","indian_cocos","+06:30"),
    INDIAN_COMORO("Indian/Comoro","indian_comoro","+03:00"),
    INDIAN_KERGUELEN("Indian/Kerguelen","indian_kerguelen","+05:00"),
    INDIAN_MAHE("Indian/Mahe","indian_mahe","+04:00"),
    INDIAN_MALDIVES("Indian/Maldives","indian_maldives","+05:00"),
    INDIAN_MAURITIUS("Indian/Mauritius","indian_mauritius","+04:00"),
    INDIAN_MAYOTTE("Indian/Mayotte","indian_mayotte","+03:00"),
    INDIAN_REUNION("Indian/Reunion","indian_reunion","+04:00"),
    IRAN("Iran","iran","+03:30"),
    ISRAEL("Israel","israel","+02:00"),
    JAMAICA("Jamaica","jamaica","-05:00"),
    JAPAN("Japan","japan","+09:00"),
    KWAJALEIN("Kwajalein","kwajalein","+12:00"),
    LIBYA("Libya","libya","+02:00"),
    MET("MET","met","+01:00"),
    MST7MDT("MST7MDT","mst7mdt","-07:00"),
    MEXICO_BAJANORTE("Mexico/BajaNorte","mexico_bajanorte","-08:00"),
    MEXICO_BAJASUR("Mexico/BajaSur","mexico_bajasur","-07:00"),
    MEXICO_GENERAL("Mexico/General","mexico_general","-06:00"),
    NZ("NZ","nz","+13:00"),
    NZ_CHAT("NZ-CHAT","nz-chat","+13:45"),
    NAVAJO("Navajo","navajo","-07:00"),
    PRC("PRC","prc","+08:00"),
    PST8PDT("PST8PDT","pst8pdt","-08:00"),
    PACIFIC_APIA("Pacific/Apia","pacific_apia","+13:00"),
    PACIFIC_AUCKLAND("Pacific/Auckland","pacific_auckland","+13:00"),
    PACIFIC_BOUGAINVILLE("Pacific/Bougainville","pacific_bougainville","+11:00"),
    PACIFIC_CHATHAM("Pacific/Chatham","pacific_chatham","+13:45"),
    PACIFIC_CHUUK("Pacific/Chuuk","pacific_chuuk","+10:00"),
    PACIFIC_EASTER("Pacific/Easter","pacific_easter","-05:00"),
    PACIFIC_EFATE("Pacific/Efate","pacific_efate","+11:00"),
    PACIFIC_ENDERBURY("Pacific/Enderbury","pacific_enderbury","+13:00"),
    PACIFIC_FAKAOFO("Pacific/Fakaofo","pacific_fakaofo","+13:00"),
    PACIFIC_FIJI("Pacific/Fiji","pacific_fiji","+12:00"),
    PACIFIC_FUNAFUTI("Pacific/Funafuti","pacific_funafuti","+12:00"),
    PACIFIC_GALAPAGOS("Pacific/Galapagos","pacific_galapagos","-06:00"),
    PACIFIC_GAMBIER("Pacific/Gambier","pacific_gambier","-09:00"),
    PACIFIC_GUADALCANAL("Pacific/Guadalcanal","pacific_guadalcanal","+11:00"),
    PACIFIC_GUAM("Pacific/Guam","pacific_guam","+10:00"),
    PACIFIC_HONOLULU("Pacific/Honolulu","pacific_honolulu","-10:00"),
    PACIFIC_JOHNSTON("Pacific/Johnston","pacific_johnston","-10:00"),
    PACIFIC_KANTON("Pacific/Kanton","pacific_kanton","+13:00"),
    PACIFIC_KIRITIMATI("Pacific/Kiritimati","pacific_kiritimati","+14:00"),
    PACIFIC_KOSRAE("Pacific/Kosrae","pacific_kosrae","+11:00"),
    PACIFIC_KWAJALEIN("Pacific/Kwajalein","pacific_kwajalein","+12:00"),
    PACIFIC_MAJURO("Pacific/Majuro","pacific_majuro","+12:00"),
    PACIFIC_MARQUESAS("Pacific/Marquesas","pacific_marquesas","-09:30"),
    PACIFIC_MIDWAY("Pacific/Midway","pacific_midway","-11:00"),
    PACIFIC_NAURU("Pacific/Nauru","pacific_nauru","+12:00"),
    PACIFIC_NIUE("Pacific/Niue","pacific_niue","-11:00"),
    PACIFIC_NORFOLK("Pacific/Norfolk","pacific_norfolk","+12:00"),
    PACIFIC_NOUMEA("Pacific/Noumea","pacific_noumea","+11:00"),
    PACIFIC_PAGO_PAGO("Pacific/Pago_Pago","pacific_pago_pago","-11:00"),
    PACIFIC_PALAU("Pacific/Palau","pacific_palau","+09:00"),
    PACIFIC_PITCAIRN("Pacific/Pitcairn","pacific_pitcairn","-08:00"),
    PACIFIC_POHNPEI("Pacific/Pohnpei","pacific_pohnpei","+11:00"),
    PACIFIC_PONAPE("Pacific/Ponape","pacific_ponape","+11:00"),
    PACIFIC_PORT_MORESBY("Pacific/Port_Moresby","pacific_port_moresby","+10:00"),
    PACIFIC_RAROTONGA("Pacific/Rarotonga","pacific_rarotonga","-10:00"),
    PACIFIC_SAIPAN("Pacific/Saipan","pacific_saipan","+10:00"),
    PACIFIC_SAMOA("Pacific/Samoa","pacific_samoa","-11:00"),
    PACIFIC_TAHITI("Pacific/Tahiti","pacific_tahiti","-10:00"),
    PACIFIC_TARAWA("Pacific/Tarawa","pacific_tarawa","+12:00"),
    PACIFIC_TONGATAPU("Pacific/Tongatapu","pacific_tongatapu","+13:00"),
    PACIFIC_TRUK("Pacific/Truk","pacific_truk","+10:00"),
    PACIFIC_WAKE("Pacific/Wake","pacific_wake","+12:00"),
    PACIFIC_WALLIS("Pacific/Wallis","pacific_wallis","+12:00"),
    PACIFIC_YAP("Pacific/Yap","pacific_yap","+10:00"),
    POLAND("Poland","poland","+01:00"),
    PORTUGAL("Portugal","portugal","+00:00"),
    ROK("ROK","rok","+09:00"),
    SINGAPORE("Singapore","singapore","+08:00"),
    SYSTEMV_AST4("SystemV/AST4","systemv_ast4","-04:00"),
    SYSTEMV_AST4ADT("SystemV/AST4ADT","systemv_ast4adt","-04:00"),
    SYSTEMV_CST6("SystemV/CST6","systemv_cst6","-06:00"),
    SYSTEMV_CST6CDT("SystemV/CST6CDT","systemv_cst6cdt","-06:00"),
    SYSTEMV_EST5("SystemV/EST5","systemv_est5","-05:00"),
    SYSTEMV_EST5EDT("SystemV/EST5EDT","systemv_est5edt","-05:00"),
    SYSTEMV_HST10("SystemV/HST10","systemv_hst10","-10:00"),
    SYSTEMV_MST7("SystemV/MST7","systemv_mst7","-07:00"),
    SYSTEMV_MST7MDT("SystemV/MST7MDT","systemv_mst7mdt","-07:00"),
    SYSTEMV_PST8("SystemV/PST8","systemv_pst8","-08:00"),
    SYSTEMV_PST8PDT("SystemV/PST8PDT","systemv_pst8pdt","-08:00"),
    SYSTEMV_YST9("SystemV/YST9","systemv_yst9","-09:00"),
    SYSTEMV_YST9YDT("SystemV/YST9YDT","systemv_yst9ydt","-09:00"),
    TURKEY("Turkey","turkey","+03:00"),
    UCT("UCT","uct","+00:00"),
    US_ALASKA("US/Alaska","us_alaska","-09:00"),
    US_ALEUTIAN("US/Aleutian","us_aleutian","-10:00"),
    US_ARIZONA("US/Arizona","us_arizona","-07:00"),
    US_CENTRAL("US/Central","us_central","-06:00"),
    US_EAST_INDIANA("US/East-Indiana","us_east-indiana","-05:00"),
    US_EASTERN("US/Eastern","us_eastern","-05:00"),
    US_HAWAII("US/Hawaii","us_hawaii","-10:00"),
    US_INDIANA_STARKE("US/Indiana-Starke","us_indiana-starke","-06:00"),
    US_MICHIGAN("US/Michigan","us_michigan","-05:00"),
    US_MOUNTAIN("US/Mountain","us_mountain","-07:00"),
    US_PACIFIC("US/Pacific","us_pacific","-08:00"),
    US_SAMOA("US/Samoa","us_samoa","-11:00"),
    UTC("UTC","utc","+00:00"),
    UNIVERSAL("Universal","universal","+00:00"),
    W_SU("W-SU","w-su","+03:00"),
    WET("WET","wet","+00:00"),
    ZULU("Zulu","zulu","+00:00"),
    NOT_FOUND("", "", "0");

    public final String uiString;
    public final String apiString;
    public final String offset;


    // ******************** Constructors **************************************
    ZoneID(final String uiString, final String apiString, final String offset) {
        this.uiString  = uiString;
        this.apiString = apiString;
        this.offset    = offset;
    }


    // ******************** Methods *******************************************
    public static final ZoneID fromText(final String text) {
        switch(text) {
            case "africa_abidjan" -> { return ZoneID.AFRICA_ABIDJAN; }
            case "africa_accra" -> { return ZoneID.AFRICA_ACCRA; }
            case "africa_addis_ababa" -> { return ZoneID.AFRICA_ADDIS_ABABA; }
            case "africa_algiers" -> { return ZoneID.AFRICA_ALGIERS; }
            case "africa_asmara" -> { return ZoneID.AFRICA_ASMARA; }
            case "africa_asmera" -> { return ZoneID.AFRICA_ASMERA; }
            case "africa_bamako" -> { return ZoneID.AFRICA_BAMAKO; }
            case "africa_bangui" -> { return ZoneID.AFRICA_BANGUI; }
            case "africa_banjul" -> { return ZoneID.AFRICA_BANJUL; }
            case "africa_bissau" -> { return ZoneID.AFRICA_BISSAU; }
            case "africa_blantyre" -> { return ZoneID.AFRICA_BLANTYRE; }
            case "africa_brazzaville" -> { return ZoneID.AFRICA_BRAZZAVILLE; }
            case "africa_bujumbura" -> { return ZoneID.AFRICA_BUJUMBURA; }
            case "africa_cairo" -> { return ZoneID.AFRICA_CAIRO; }
            case "africa_casablanca" -> { return ZoneID.AFRICA_CASABLANCA; }
            case "africa_ceuta" -> { return ZoneID.AFRICA_CEUTA; }
            case "africa_conakry" -> { return ZoneID.AFRICA_CONAKRY; }
            case "africa_dakar" -> { return ZoneID.AFRICA_DAKAR; }
            case "africa_dar_es_salaam" -> { return ZoneID.AFRICA_DAR_ES_SALAAM; }
            case "africa_djibouti" -> { return ZoneID.AFRICA_DJIBOUTI; }
            case "africa_douala" -> { return ZoneID.AFRICA_DOUALA; }
            case "africa_el_aaiun" -> { return ZoneID.AFRICA_EL_AAIUN; }
            case "africa_freetown" -> { return ZoneID.AFRICA_FREETOWN; }
            case "africa_gaborone" -> { return ZoneID.AFRICA_GABORONE; }
            case "africa_harare" -> { return ZoneID.AFRICA_HARARE; }
            case "africa_johannesburg" -> { return ZoneID.AFRICA_JOHANNESBURG; }
            case "africa_juba" -> { return ZoneID.AFRICA_JUBA; }
            case "africa_kampala" -> { return ZoneID.AFRICA_KAMPALA; }
            case "africa_khartoum" -> { return ZoneID.AFRICA_KHARTOUM; }
            case "africa_kigali" -> { return ZoneID.AFRICA_KIGALI; }
            case "africa_kinshasa" -> { return ZoneID.AFRICA_KINSHASA; }
            case "africa_lagos" -> { return ZoneID.AFRICA_LAGOS; }
            case "africa_libreville" -> { return ZoneID.AFRICA_LIBREVILLE; }
            case "africa_lome" -> { return ZoneID.AFRICA_LOME; }
            case "africa_luanda" -> { return ZoneID.AFRICA_LUANDA; }
            case "africa_lubumbashi" -> { return ZoneID.AFRICA_LUBUMBASHI; }
            case "africa_lusaka" -> { return ZoneID.AFRICA_LUSAKA; }
            case "africa_malabo" -> { return ZoneID.AFRICA_MALABO; }
            case "africa_maputo" -> { return ZoneID.AFRICA_MAPUTO; }
            case "africa_maseru" -> { return ZoneID.AFRICA_MASERU; }
            case "africa_mbabane" -> { return ZoneID.AFRICA_MBABANE; }
            case "africa_mogadishu" -> { return ZoneID.AFRICA_MOGADISHU; }
            case "africa_monrovia" -> { return ZoneID.AFRICA_MONROVIA; }
            case "africa_nairobi" -> { return ZoneID.AFRICA_NAIROBI; }
            case "africa_ndjamena" -> { return ZoneID.AFRICA_NDJAMENA; }
            case "africa_niamey" -> { return ZoneID.AFRICA_NIAMEY; }
            case "africa_nouakchott" -> { return ZoneID.AFRICA_NOUAKCHOTT; }
            case "africa_ouagadougou" -> { return ZoneID.AFRICA_OUAGADOUGOU; }
            case "africa_porto-novo" -> { return ZoneID.AFRICA_PORTO_NOVO; }
            case "africa_sao_tome" -> { return ZoneID.AFRICA_SAO_TOME; }
            case "africa_timbuktu" -> { return ZoneID.AFRICA_TIMBUKTU; }
            case "africa_tripoli" -> { return ZoneID.AFRICA_TRIPOLI; }
            case "africa_tunis" -> { return ZoneID.AFRICA_TUNIS; }
            case "africa_windhoek" -> { return ZoneID.AFRICA_WINDHOEK; }
            case "america_adak" -> { return ZoneID.AMERICA_ADAK; }
            case "america_anchorage" -> { return ZoneID.AMERICA_ANCHORAGE; }
            case "america_anguilla" -> { return ZoneID.AMERICA_ANGUILLA; }
            case "america_antigua" -> { return ZoneID.AMERICA_ANTIGUA; }
            case "america_araguaina" -> { return ZoneID.AMERICA_ARAGUAINA; }
            case "america_argentina_buenos_aires" -> { return ZoneID.AMERICA_ARGENTINA_BUENOS_AIRES; }
            case "america_argentina_catamarca" -> { return ZoneID.AMERICA_ARGENTINA_CATAMARCA; }
            case "america_argentina_comodrivadavia" -> { return ZoneID.AMERICA_ARGENTINA_COMODRIVADAVIA; }
            case "america_argentina_cordoba" -> { return ZoneID.AMERICA_ARGENTINA_CORDOBA; }
            case "america_argentina_jujuy" -> { return ZoneID.AMERICA_ARGENTINA_JUJUY; }
            case "america_argentina_la_rioja" -> { return ZoneID.AMERICA_ARGENTINA_LA_RIOJA; }
            case "america_argentina_mendoza" -> { return ZoneID.AMERICA_ARGENTINA_MENDOZA; }
            case "america_argentina_rio_gallegos" -> { return ZoneID.AMERICA_ARGENTINA_RIO_GALLEGOS; }
            case "america_argentina_salta" -> { return ZoneID.AMERICA_ARGENTINA_SALTA; }
            case "america_argentina_san_juan" -> { return ZoneID.AMERICA_ARGENTINA_SAN_JUAN; }
            case "america_argentina_san_luis" -> { return ZoneID.AMERICA_ARGENTINA_SAN_LUIS; }
            case "america_argentina_tucuman" -> { return ZoneID.AMERICA_ARGENTINA_TUCUMAN; }
            case "america_argentina_ushuaia" -> { return ZoneID.AMERICA_ARGENTINA_USHUAIA; }
            case "america_aruba" -> { return ZoneID.AMERICA_ARUBA; }
            case "america_asuncion" -> { return ZoneID.AMERICA_ASUNCION; }
            case "america_atikokan" -> { return ZoneID.AMERICA_ATIKOKAN; }
            case "america_atka" -> { return ZoneID.AMERICA_ATKA; }
            case "america_bahia" -> { return ZoneID.AMERICA_BAHIA; }
            case "america_bahia_banderas" -> { return ZoneID.AMERICA_BAHIA_BANDERAS; }
            case "america_barbados" -> { return ZoneID.AMERICA_BARBADOS; }
            case "america_belem" -> { return ZoneID.AMERICA_BELEM; }
            case "america_belize" -> { return ZoneID.AMERICA_BELIZE; }
            case "america_blanc-sablon" -> { return ZoneID.AMERICA_BLANC_SABLON; }
            case "america_boa_vista" -> { return ZoneID.AMERICA_BOA_VISTA; }
            case "america_bogota" -> { return ZoneID.AMERICA_BOGOTA; }
            case "america_boise" -> { return ZoneID.AMERICA_BOISE; }
            case "america_buenos_aires" -> { return ZoneID.AMERICA_BUENOS_AIRES; }
            case "america_cambridge_bay" -> { return ZoneID.AMERICA_CAMBRIDGE_BAY; }
            case "america_campo_grande" -> { return ZoneID.AMERICA_CAMPO_GRANDE; }
            case "america_cancun" -> { return ZoneID.AMERICA_CANCUN; }
            case "america_caracas" -> { return ZoneID.AMERICA_CARACAS; }
            case "america_catamarca" -> { return ZoneID.AMERICA_CATAMARCA; }
            case "america_cayenne" -> { return ZoneID.AMERICA_CAYENNE; }
            case "america_cayman" -> { return ZoneID.AMERICA_CAYMAN; }
            case "america_chicago" -> { return ZoneID.AMERICA_CHICAGO; }
            case "america_chihuahua" -> { return ZoneID.AMERICA_CHIHUAHUA; }
            case "america_ciudad_juarez" -> { return ZoneID.AMERICA_CIUDAD_JUAREZ; }
            case "america_coral_harbour" -> { return ZoneID.AMERICA_CORAL_HARBOUR; }
            case "america_cordoba" -> { return ZoneID.AMERICA_CORDOBA; }
            case "america_costa_rica" -> { return ZoneID.AMERICA_COSTA_RICA; }
            case "america_creston" -> { return ZoneID.AMERICA_CRESTON; }
            case "america_cuiaba" -> { return ZoneID.AMERICA_CUIABA; }
            case "america_curacao" -> { return ZoneID.AMERICA_CURACAO; }
            case "america_danmarkshavn" -> { return ZoneID.AMERICA_DANMARKSHAVN; }
            case "america_dawson" -> { return ZoneID.AMERICA_DAWSON; }
            case "america_dawson_creek" -> { return ZoneID.AMERICA_DAWSON_CREEK; }
            case "america_denver" -> { return ZoneID.AMERICA_DENVER; }
            case "america_detroit" -> { return ZoneID.AMERICA_DETROIT; }
            case "america_dominica" -> { return ZoneID.AMERICA_DOMINICA; }
            case "america_edmonton" -> { return ZoneID.AMERICA_EDMONTON; }
            case "america_eirunepe" -> { return ZoneID.AMERICA_EIRUNEPE; }
            case "america_el_salvador" -> { return ZoneID.AMERICA_EL_SALVADOR; }
            case "america_ensenada" -> { return ZoneID.AMERICA_ENSENADA; }
            case "america_fort_nelson" -> { return ZoneID.AMERICA_FORT_NELSON; }
            case "america_fort_wayne" -> { return ZoneID.AMERICA_FORT_WAYNE; }
            case "america_fortaleza" -> { return ZoneID.AMERICA_FORTALEZA; }
            case "america_glace_bay" -> { return ZoneID.AMERICA_GLACE_BAY; }
            case "america_godthab" -> { return ZoneID.AMERICA_GODTHAB; }
            case "america_goose_bay" -> { return ZoneID.AMERICA_GOOSE_BAY; }
            case "america_grand_turk" -> { return ZoneID.AMERICA_GRAND_TURK; }
            case "america_grenada" -> { return ZoneID.AMERICA_GRENADA; }
            case "america_guadeloupe" -> { return ZoneID.AMERICA_GUADELOUPE; }
            case "america_guatemala" -> { return ZoneID.AMERICA_GUATEMALA; }
            case "america_guayaquil" -> { return ZoneID.AMERICA_GUAYAQUIL; }
            case "america_guyana" -> { return ZoneID.AMERICA_GUYANA; }
            case "america_halifax" -> { return ZoneID.AMERICA_HALIFAX; }
            case "america_havana" -> { return ZoneID.AMERICA_HAVANA; }
            case "america_hermosillo" -> { return ZoneID.AMERICA_HERMOSILLO; }
            case "america_indiana_indianapolis" -> { return ZoneID.AMERICA_INDIANA_INDIANAPOLIS; }
            case "america_indiana_knox" -> { return ZoneID.AMERICA_INDIANA_KNOX; }
            case "america_indiana_marengo" -> { return ZoneID.AMERICA_INDIANA_MARENGO; }
            case "america_indiana_petersburg" -> { return ZoneID.AMERICA_INDIANA_PETERSBURG; }
            case "america_indiana_tell_city" -> { return ZoneID.AMERICA_INDIANA_TELL_CITY; }
            case "america_indiana_vevay" -> { return ZoneID.AMERICA_INDIANA_VEVAY; }
            case "america_indiana_vincennes" -> { return ZoneID.AMERICA_INDIANA_VINCENNES; }
            case "america_indiana_winamac" -> { return ZoneID.AMERICA_INDIANA_WINAMAC; }
            case "america_indianapolis" -> { return ZoneID.AMERICA_INDIANAPOLIS; }
            case "america_inuvik" -> { return ZoneID.AMERICA_INUVIK; }
            case "america_iqaluit" -> { return ZoneID.AMERICA_IQALUIT; }
            case "america_jamaica" -> { return ZoneID.AMERICA_JAMAICA; }
            case "america_jujuy" -> { return ZoneID.AMERICA_JUJUY; }
            case "america_juneau" -> { return ZoneID.AMERICA_JUNEAU; }
            case "america_kentucky_louisville" -> { return ZoneID.AMERICA_KENTUCKY_LOUISVILLE; }
            case "america_kentucky_monticello" -> { return ZoneID.AMERICA_KENTUCKY_MONTICELLO; }
            case "america_knox_in" -> { return ZoneID.AMERICA_KNOX_IN; }
            case "america_kralendijk" -> { return ZoneID.AMERICA_KRALENDIJK; }
            case "america_la_paz" -> { return ZoneID.AMERICA_LA_PAZ; }
            case "america_lima" -> { return ZoneID.AMERICA_LIMA; }
            case "america_los_angeles" -> { return ZoneID.AMERICA_LOS_ANGELES; }
            case "america_louisville" -> { return ZoneID.AMERICA_LOUISVILLE; }
            case "america_lower_princes" -> { return ZoneID.AMERICA_LOWER_PRINCES; }
            case "america_maceio" -> { return ZoneID.AMERICA_MACEIO; }
            case "america_managua" -> { return ZoneID.AMERICA_MANAGUA; }
            case "america_manaus" -> { return ZoneID.AMERICA_MANAUS; }
            case "america_marigot" -> { return ZoneID.AMERICA_MARIGOT; }
            case "america_martinique" -> { return ZoneID.AMERICA_MARTINIQUE; }
            case "america_matamoros" -> { return ZoneID.AMERICA_MATAMOROS; }
            case "america_mazatlan" -> { return ZoneID.AMERICA_MAZATLAN; }
            case "america_mendoza" -> { return ZoneID.AMERICA_MENDOZA; }
            case "america_menominee" -> { return ZoneID.AMERICA_MENOMINEE; }
            case "america_merida" -> { return ZoneID.AMERICA_MERIDA; }
            case "america_metlakatla" -> { return ZoneID.AMERICA_METLAKATLA; }
            case "america_mexico_city" -> { return ZoneID.AMERICA_MEXICO_CITY; }
            case "america_miquelon" -> { return ZoneID.AMERICA_MIQUELON; }
            case "america_moncton" -> { return ZoneID.AMERICA_MONCTON; }
            case "america_monterrey" -> { return ZoneID.AMERICA_MONTERREY; }
            case "america_montevideo" -> { return ZoneID.AMERICA_MONTEVIDEO; }
            case "america_montreal" -> { return ZoneID.AMERICA_MONTREAL; }
            case "america_montserrat" -> { return ZoneID.AMERICA_MONTSERRAT; }
            case "america_nassau" -> { return ZoneID.AMERICA_NASSAU; }
            case "america_new_york" -> { return ZoneID.AMERICA_NEW_YORK; }
            case "america_nipigon" -> { return ZoneID.AMERICA_NIPIGON; }
            case "america_nome" -> { return ZoneID.AMERICA_NOME; }
            case "america_noronha" -> { return ZoneID.AMERICA_NORONHA; }
            case "america_north_dakota_beulah" -> { return ZoneID.AMERICA_NORTH_DAKOTA_BEULAH; }
            case "america_north_dakota_center" -> { return ZoneID.AMERICA_NORTH_DAKOTA_CENTER; }
            case "america_north_dakota_new_salem" -> { return ZoneID.AMERICA_NORTH_DAKOTA_NEW_SALEM; }
            case "america_nuuk" -> { return ZoneID.AMERICA_NUUK; }
            case "america_ojinaga" -> { return ZoneID.AMERICA_OJINAGA; }
            case "america_panama" -> { return ZoneID.AMERICA_PANAMA; }
            case "america_pangnirtung" -> { return ZoneID.AMERICA_PANGNIRTUNG; }
            case "america_paramaribo" -> { return ZoneID.AMERICA_PARAMARIBO; }
            case "america_phoenix" -> { return ZoneID.AMERICA_PHOENIX; }
            case "america_port-au-prince" -> { return ZoneID.AMERICA_PORT_AU_PRINCE; }
            case "america_port_of_spain" -> { return ZoneID.AMERICA_PORT_OF_SPAIN; }
            case "america_porto_acre" -> { return ZoneID.AMERICA_PORTO_ACRE; }
            case "america_porto_velho" -> { return ZoneID.AMERICA_PORTO_VELHO; }
            case "america_puerto_rico" -> { return ZoneID.AMERICA_PUERTO_RICO; }
            case "america_punta_arenas" -> { return ZoneID.AMERICA_PUNTA_ARENAS; }
            case "america_rainy_river" -> { return ZoneID.AMERICA_RAINY_RIVER; }
            case "america_rankin_inlet" -> { return ZoneID.AMERICA_RANKIN_INLET; }
            case "america_recife" -> { return ZoneID.AMERICA_RECIFE; }
            case "america_regina" -> { return ZoneID.AMERICA_REGINA; }
            case "america_resolute" -> { return ZoneID.AMERICA_RESOLUTE; }
            case "america_rio_branco" -> { return ZoneID.AMERICA_RIO_BRANCO; }
            case "america_rosario" -> { return ZoneID.AMERICA_ROSARIO; }
            case "america_santa_isabel" -> { return ZoneID.AMERICA_SANTA_ISABEL; }
            case "america_santarem" -> { return ZoneID.AMERICA_SANTAREM; }
            case "america_santiago" -> { return ZoneID.AMERICA_SANTIAGO; }
            case "america_santo_domingo" -> { return ZoneID.AMERICA_SANTO_DOMINGO; }
            case "america_sao_paulo" -> { return ZoneID.AMERICA_SAO_PAULO; }
            case "america_scoresbysund" -> { return ZoneID.AMERICA_SCORESBYSUND; }
            case "america_shiprock" -> { return ZoneID.AMERICA_SHIPROCK; }
            case "america_sitka" -> { return ZoneID.AMERICA_SITKA; }
            case "america_st_barthelemy" -> { return ZoneID.AMERICA_ST_BARTHELEMY; }
            case "america_st_johns" -> { return ZoneID.AMERICA_ST_JOHNS; }
            case "america_st_kitts" -> { return ZoneID.AMERICA_ST_KITTS; }
            case "america_st_lucia" -> { return ZoneID.AMERICA_ST_LUCIA; }
            case "america_st_thomas" -> { return ZoneID.AMERICA_ST_THOMAS; }
            case "america_st_vincent" -> { return ZoneID.AMERICA_ST_VINCENT; }
            case "america_swift_current" -> { return ZoneID.AMERICA_SWIFT_CURRENT; }
            case "america_tegucigalpa" -> { return ZoneID.AMERICA_TEGUCIGALPA; }
            case "america_thule" -> { return ZoneID.AMERICA_THULE; }
            case "america_thunder_bay" -> { return ZoneID.AMERICA_THUNDER_BAY; }
            case "america_tijuana" -> { return ZoneID.AMERICA_TIJUANA; }
            case "america_toronto" -> { return ZoneID.AMERICA_TORONTO; }
            case "america_tortola" -> { return ZoneID.AMERICA_TORTOLA; }
            case "america_vancouver" -> { return ZoneID.AMERICA_VANCOUVER; }
            case "america_virgin" -> { return ZoneID.AMERICA_VIRGIN; }
            case "america_whitehorse" -> { return ZoneID.AMERICA_WHITEHORSE; }
            case "america_winnipeg" -> { return ZoneID.AMERICA_WINNIPEG; }
            case "america_yakutat" -> { return ZoneID.AMERICA_YAKUTAT; }
            case "america_yellowknife" -> { return ZoneID.AMERICA_YELLOWKNIFE; }
            case "antarctica_casey" -> { return ZoneID.ANTARCTICA_CASEY; }
            case "antarctica_davis" -> { return ZoneID.ANTARCTICA_DAVIS; }
            case "antarctica_dumontdurville" -> { return ZoneID.ANTARCTICA_DUMONTDURVILLE; }
            case "antarctica_macquarie" -> { return ZoneID.ANTARCTICA_MACQUARIE; }
            case "antarctica_mawson" -> { return ZoneID.ANTARCTICA_MAWSON; }
            case "antarctica_mcmurdo" -> { return ZoneID.ANTARCTICA_MCMURDO; }
            case "antarctica_palmer" -> { return ZoneID.ANTARCTICA_PALMER; }
            case "antarctica_rothera" -> { return ZoneID.ANTARCTICA_ROTHERA; }
            case "antarctica_south_pole" -> { return ZoneID.ANTARCTICA_SOUTH_POLE; }
            case "antarctica_syowa" -> { return ZoneID.ANTARCTICA_SYOWA; }
            case "antarctica_troll" -> { return ZoneID.ANTARCTICA_TROLL; }
            case "antarctica_vostok" -> { return ZoneID.ANTARCTICA_VOSTOK; }
            case "arctic_longyearbyen" -> { return ZoneID.ARCTIC_LONGYEARBYEN; }
            case "asia_aden" -> { return ZoneID.ASIA_ADEN; }
            case "asia_almaty" -> { return ZoneID.ASIA_ALMATY; }
            case "asia_amman" -> { return ZoneID.ASIA_AMMAN; }
            case "asia_anadyr" -> { return ZoneID.ASIA_ANADYR; }
            case "asia_aqtau" -> { return ZoneID.ASIA_AQTAU; }
            case "asia_aqtobe" -> { return ZoneID.ASIA_AQTOBE; }
            case "asia_ashgabat" -> { return ZoneID.ASIA_ASHGABAT; }
            case "asia_ashkhabad" -> { return ZoneID.ASIA_ASHKHABAD; }
            case "asia_atyrau" -> { return ZoneID.ASIA_ATYRAU; }
            case "asia_baghdad" -> { return ZoneID.ASIA_BAGHDAD; }
            case "asia_bahrain" -> { return ZoneID.ASIA_BAHRAIN; }
            case "asia_baku" -> { return ZoneID.ASIA_BAKU; }
            case "asia_bangkok" -> { return ZoneID.ASIA_BANGKOK; }
            case "asia_barnaul" -> { return ZoneID.ASIA_BARNAUL; }
            case "asia_beirut" -> { return ZoneID.ASIA_BEIRUT; }
            case "asia_bishkek" -> { return ZoneID.ASIA_BISHKEK; }
            case "asia_brunei" -> { return ZoneID.ASIA_BRUNEI; }
            case "asia_calcutta" -> { return ZoneID.ASIA_CALCUTTA; }
            case "asia_chita" -> { return ZoneID.ASIA_CHITA; }
            case "asia_choibalsan" -> { return ZoneID.ASIA_CHOIBALSAN; }
            case "asia_chongqing" -> { return ZoneID.ASIA_CHONGQING; }
            case "asia_chungking" -> { return ZoneID.ASIA_CHUNGKING; }
            case "asia_colombo" -> { return ZoneID.ASIA_COLOMBO; }
            case "asia_dacca" -> { return ZoneID.ASIA_DACCA; }
            case "asia_damascus" -> { return ZoneID.ASIA_DAMASCUS; }
            case "asia_dhaka" -> { return ZoneID.ASIA_DHAKA; }
            case "asia_dili" -> { return ZoneID.ASIA_DILI; }
            case "asia_dubai" -> { return ZoneID.ASIA_DUBAI; }
            case "asia_dushanbe" -> { return ZoneID.ASIA_DUSHANBE; }
            case "asia_famagusta" -> { return ZoneID.ASIA_FAMAGUSTA; }
            case "asia_gaza" -> { return ZoneID.ASIA_GAZA; }
            case "asia_harbin" -> { return ZoneID.ASIA_HARBIN; }
            case "asia_hebron" -> { return ZoneID.ASIA_HEBRON; }
            case "asia_ho_chi_minh" -> { return ZoneID.ASIA_HO_CHI_MINH; }
            case "asia_hong_kong" -> { return ZoneID.ASIA_HONG_KONG; }
            case "asia_hovd" -> { return ZoneID.ASIA_HOVD; }
            case "asia_irkutsk" -> { return ZoneID.ASIA_IRKUTSK; }
            case "asia_istanbul" -> { return ZoneID.ASIA_ISTANBUL; }
            case "asia_jakarta" -> { return ZoneID.ASIA_JAKARTA; }
            case "asia_jayapura" -> { return ZoneID.ASIA_JAYAPURA; }
            case "asia_jerusalem" -> { return ZoneID.ASIA_JERUSALEM; }
            case "asia_kabul" -> { return ZoneID.ASIA_KABUL; }
            case "asia_kamchatka" -> { return ZoneID.ASIA_KAMCHATKA; }
            case "asia_karachi" -> { return ZoneID.ASIA_KARACHI; }
            case "asia_kashgar" -> { return ZoneID.ASIA_KASHGAR; }
            case "asia_kathmandu" -> { return ZoneID.ASIA_KATHMANDU; }
            case "asia_katmandu" -> { return ZoneID.ASIA_KATMANDU; }
            case "asia_khandyga" -> { return ZoneID.ASIA_KHANDYGA; }
            case "asia_kolkata" -> { return ZoneID.ASIA_KOLKATA; }
            case "asia_krasnoyarsk" -> { return ZoneID.ASIA_KRASNOYARSK; }
            case "asia_kuala_lumpur" -> { return ZoneID.ASIA_KUALA_LUMPUR; }
            case "asia_kuching" -> { return ZoneID.ASIA_KUCHING; }
            case "asia_kuwait" -> { return ZoneID.ASIA_KUWAIT; }
            case "asia_macao" -> { return ZoneID.ASIA_MACAO; }
            case "asia_macau" -> { return ZoneID.ASIA_MACAU; }
            case "asia_magadan" -> { return ZoneID.ASIA_MAGADAN; }
            case "asia_makassar" -> { return ZoneID.ASIA_MAKASSAR; }
            case "asia_manila" -> { return ZoneID.ASIA_MANILA; }
            case "asia_muscat" -> { return ZoneID.ASIA_MUSCAT; }
            case "asia_nicosia" -> { return ZoneID.ASIA_NICOSIA; }
            case "asia_novokuznetsk" -> { return ZoneID.ASIA_NOVOKUZNETSK; }
            case "asia_novosibirsk" -> { return ZoneID.ASIA_NOVOSIBIRSK; }
            case "asia_omsk" -> { return ZoneID.ASIA_OMSK; }
            case "asia_oral" -> { return ZoneID.ASIA_ORAL; }
            case "asia_phnom_penh" -> { return ZoneID.ASIA_PHNOM_PENH; }
            case "asia_pontianak" -> { return ZoneID.ASIA_PONTIANAK; }
            case "asia_pyongyang" -> { return ZoneID.ASIA_PYONGYANG; }
            case "asia_qatar" -> { return ZoneID.ASIA_QATAR; }
            case "asia_qostanay" -> { return ZoneID.ASIA_QOSTANAY; }
            case "asia_qyzylorda" -> { return ZoneID.ASIA_QYZYLORDA; }
            case "asia_rangoon" -> { return ZoneID.ASIA_RANGOON; }
            case "asia_riyadh" -> { return ZoneID.ASIA_RIYADH; }
            case "asia_saigon" -> { return ZoneID.ASIA_SAIGON; }
            case "asia_sakhalin" -> { return ZoneID.ASIA_SAKHALIN; }
            case "asia_samarkand" -> { return ZoneID.ASIA_SAMARKAND; }
            case "asia_seoul" -> { return ZoneID.ASIA_SEOUL; }
            case "asia_shanghai" -> { return ZoneID.ASIA_SHANGHAI; }
            case "asia_singapore" -> { return ZoneID.ASIA_SINGAPORE; }
            case "asia_srednekolymsk" -> { return ZoneID.ASIA_SREDNEKOLYMSK; }
            case "asia_taipei" -> { return ZoneID.ASIA_TAIPEI; }
            case "asia_tashkent" -> { return ZoneID.ASIA_TASHKENT; }
            case "asia_tbilisi" -> { return ZoneID.ASIA_TBILISI; }
            case "asia_tehran" -> { return ZoneID.ASIA_TEHRAN; }
            case "asia_tel_aviv" -> { return ZoneID.ASIA_TEL_AVIV; }
            case "asia_thimbu" -> { return ZoneID.ASIA_THIMBU; }
            case "asia_thimphu" -> { return ZoneID.ASIA_THIMPHU; }
            case "asia_tokyo" -> { return ZoneID.ASIA_TOKYO; }
            case "asia_tomsk" -> { return ZoneID.ASIA_TOMSK; }
            case "asia_ujung_pandang" -> { return ZoneID.ASIA_UJUNG_PANDANG; }
            case "asia_ulaanbaatar" -> { return ZoneID.ASIA_ULAANBAATAR; }
            case "asia_ulan_bator" -> { return ZoneID.ASIA_ULAN_BATOR; }
            case "asia_urumqi" -> { return ZoneID.ASIA_URUMQI; }
            case "asia_ust-nera" -> { return ZoneID.ASIA_UST_NERA; }
            case "asia_vientiane" -> { return ZoneID.ASIA_VIENTIANE; }
            case "asia_vladivostok" -> { return ZoneID.ASIA_VLADIVOSTOK; }
            case "asia_yakutsk" -> { return ZoneID.ASIA_YAKUTSK; }
            case "asia_yangon" -> { return ZoneID.ASIA_YANGON; }
            case "asia_yekaterinburg" -> { return ZoneID.ASIA_YEKATERINBURG; }
            case "asia_yerevan" -> { return ZoneID.ASIA_YEREVAN; }
            case "atlantic_azores" -> { return ZoneID.ATLANTIC_AZORES; }
            case "atlantic_bermuda" -> { return ZoneID.ATLANTIC_BERMUDA; }
            case "atlantic_canary" -> { return ZoneID.ATLANTIC_CANARY; }
            case "atlantic_cape_verde" -> { return ZoneID.ATLANTIC_CAPE_VERDE; }
            case "atlantic_faeroe" -> { return ZoneID.ATLANTIC_FAEROE; }
            case "atlantic_faroe" -> { return ZoneID.ATLANTIC_FAROE; }
            case "atlantic_jan_mayen" -> { return ZoneID.ATLANTIC_JAN_MAYEN; }
            case "atlantic_madeira" -> { return ZoneID.ATLANTIC_MADEIRA; }
            case "atlantic_reykjavik" -> { return ZoneID.ATLANTIC_REYKJAVIK; }
            case "atlantic_south_georgia" -> { return ZoneID.ATLANTIC_SOUTH_GEORGIA; }
            case "atlantic_st_helena" -> { return ZoneID.ATLANTIC_ST_HELENA; }
            case "atlantic_stanley" -> { return ZoneID.ATLANTIC_STANLEY; }
            case "australia_act" -> { return ZoneID.AUSTRALIA_ACT; }
            case "australia_adelaide" -> { return ZoneID.AUSTRALIA_ADELAIDE; }
            case "australia_brisbane" -> { return ZoneID.AUSTRALIA_BRISBANE; }
            case "australia_broken_hill" -> { return ZoneID.AUSTRALIA_BROKEN_HILL; }
            case "australia_canberra" -> { return ZoneID.AUSTRALIA_CANBERRA; }
            case "australia_currie" -> { return ZoneID.AUSTRALIA_CURRIE; }
            case "australia_darwin" -> { return ZoneID.AUSTRALIA_DARWIN; }
            case "australia_eucla" -> { return ZoneID.AUSTRALIA_EUCLA; }
            case "australia_hobart" -> { return ZoneID.AUSTRALIA_HOBART; }
            case "australia_lhi" -> { return ZoneID.AUSTRALIA_LHI; }
            case "australia_lindeman" -> { return ZoneID.AUSTRALIA_LINDEMAN; }
            case "australia_lord_howe" -> { return ZoneID.AUSTRALIA_LORD_HOWE; }
            case "australia_melbourne" -> { return ZoneID.AUSTRALIA_MELBOURNE; }
            case "australia_nsw" -> { return ZoneID.AUSTRALIA_NSW; }
            case "australia_north" -> { return ZoneID.AUSTRALIA_NORTH; }
            case "australia_perth" -> { return ZoneID.AUSTRALIA_PERTH; }
            case "australia_queensland" -> { return ZoneID.AUSTRALIA_QUEENSLAND; }
            case "australia_south" -> { return ZoneID.AUSTRALIA_SOUTH; }
            case "australia_sydney" -> { return ZoneID.AUSTRALIA_SYDNEY; }
            case "australia_tasmania" -> { return ZoneID.AUSTRALIA_TASMANIA; }
            case "australia_victoria" -> { return ZoneID.AUSTRALIA_VICTORIA; }
            case "australia_west" -> { return ZoneID.AUSTRALIA_WEST; }
            case "australia_yancowinna" -> { return ZoneID.AUSTRALIA_YANCOWINNA; }
            case "brazil_acre" -> { return ZoneID.BRAZIL_ACRE; }
            case "brazil_denoronha" -> { return ZoneID.BRAZIL_DENORONHA; }
            case "brazil_east" -> { return ZoneID.BRAZIL_EAST; }
            case "brazil_west" -> { return ZoneID.BRAZIL_WEST; }
            case "cet" -> { return ZoneID.CET; }
            case "cst6cdt"-> { return ZoneID.CST6CDT; }
            case "canada_atlantic" -> { return ZoneID.CANADA_ATLANTIC; }
            case "canada_central" -> { return ZoneID.CANADA_CENTRAL; }
            case "canada_eastern" -> { return ZoneID.CANADA_EASTERN; }
            case "canada_mountain" -> { return ZoneID.CANADA_MOUNTAIN; }
            case "canada_newfoundland" -> { return ZoneID.CANADA_NEWFOUNDLAND; }
            case "canada_pacific" -> { return ZoneID.CANADA_PACIFIC; }
            case "canada_saskatchewan" -> { return ZoneID.CANADA_SASKATCHEWAN; }
            case "canada_yukon" -> { return ZoneID.CANADA_YUKON; }
            case "chile_continental" -> { return ZoneID.CHILE_CONTINENTAL; }
            case "chile_easterisland" -> { return ZoneID.CHILE_EASTERISLAND; }
            case "cuba" -> { return ZoneID.CUBA; }
            case "eet" -> { return ZoneID.EET; }
            case "est5edt"-> { return ZoneID.EST5EDT; }
            case "egypt" -> { return ZoneID.EGYPT; }
            case "eire" -> { return ZoneID.EIRE; }
            case "etc_gmt" -> { return ZoneID.ETC_GMT; }
            case "etc_gmt+0"-> { return ZoneID.ETC_GMT_PLUS_0; }
            case "etc_gmt+1"-> { return ZoneID.ETC_GMT_PLUS_1; }
            case "etc_gmt+10"-> { return ZoneID.ETC_GMT_PLUS_10; }
            case "etc_gmt+11"-> { return ZoneID.ETC_GMT_PLUS_11; }
            case "etc_gmt+12"-> { return ZoneID.ETC_GMT_PLUS_12; }
            case "etc_gmt+2"-> { return ZoneID.ETC_GMT_PLUS_2; }
            case "etc_gmt+3"-> { return ZoneID.ETC_GMT_PLUS_3; }
            case "etc_gmt+4"-> { return ZoneID.ETC_GMT_PLUS_4; }
            case "etc_gmt+5"-> { return ZoneID.ETC_GMT_PLUS_5; }
            case "etc_gmt+6"-> { return ZoneID.ETC_GMT_PLUS_6; }
            case "etc_gmt+7"-> { return ZoneID.ETC_GMT_PLUS_7; }
            case "etc_gmt+8"-> { return ZoneID.ETC_GMT_PLUS_8; }
            case "etc_gmt+9"-> { return ZoneID.ETC_GMT_PLUS_9; }
            case "etc_gmt-0"-> { return ZoneID.ETC_GMT_MINUS_0; }
            case "etc_gmt-1"-> { return ZoneID.ETC_GMT_MINUS_1; }
            case "etc_gmt-10"-> { return ZoneID.ETC_GMT_MINUS_10; }
            case "etc_gmt-11"-> { return ZoneID.ETC_GMT_MINUS_11; }
            case "etc_gmt-12"-> { return ZoneID.ETC_GMT_MINUS_12; }
            case "etc_gmt-13"-> { return ZoneID.ETC_GMT_MINUS_13; }
            case "etc_gmt-14"-> { return ZoneID.ETC_GMT_MINUS_14; }
            case "etc_gmt-2"-> { return ZoneID.ETC_GMT_MINUS_2; }
            case "etc_gmt-3"-> { return ZoneID.ETC_GMT_MINUS_3; }
            case "etc_gmt-4"-> { return ZoneID.ETC_GMT_MINUS_4; }
            case "etc_gmt-5"-> { return ZoneID.ETC_GMT_MINUS_5; }
            case "etc_gmt-6"-> { return ZoneID.ETC_GMT_MINUS_6; }
            case "etc_gmt-7"-> { return ZoneID.ETC_GMT_MINUS_7; }
            case "etc_gmt-8"-> { return ZoneID.ETC_GMT_MINUS_8; }
            case "etc_gmt-9"-> { return ZoneID.ETC_GMT_MINUS_9; }
            case "etc_gmt0"-> { return ZoneID.ETC_GMT0; }
            case "etc_greenwich" -> { return ZoneID.ETC_GREENWICH; }
            case "etc_uct" -> { return ZoneID.ETC_UCT; }
            case "etc_utc" -> { return ZoneID.ETC_UTC; }
            case "etc_universal" -> { return ZoneID.ETC_UNIVERSAL; }
            case "etc_zulu" -> { return ZoneID.ETC_ZULU; }
            case "europe_amsterdam" -> { return ZoneID.EUROPE_AMSTERDAM; }
            case "europe_andorra" -> { return ZoneID.EUROPE_ANDORRA; }
            case "europe_astrakhan" -> { return ZoneID.EUROPE_ASTRAKHAN; }
            case "europe_athens" -> { return ZoneID.EUROPE_ATHENS; }
            case "europe_belfast" -> { return ZoneID.EUROPE_BELFAST; }
            case "europe_belgrade" -> { return ZoneID.EUROPE_BELGRADE; }
            case "europe_berlin" -> { return ZoneID.EUROPE_BERLIN; }
            case "europe_bratislava" -> { return ZoneID.EUROPE_BRATISLAVA; }
            case "europe_brussels" -> { return ZoneID.EUROPE_BRUSSELS; }
            case "europe_bucharest" -> { return ZoneID.EUROPE_BUCHAREST; }
            case "europe_budapest" -> { return ZoneID.EUROPE_BUDAPEST; }
            case "europe_busingen" -> { return ZoneID.EUROPE_BUSINGEN; }
            case "europe_chisinau" -> { return ZoneID.EUROPE_CHISINAU; }
            case "europe_copenhagen" -> { return ZoneID.EUROPE_COPENHAGEN; }
            case "europe_dublin" -> { return ZoneID.EUROPE_DUBLIN; }
            case "europe_gibraltar" -> { return ZoneID.EUROPE_GIBRALTAR; }
            case "europe_guernsey" -> { return ZoneID.EUROPE_GUERNSEY; }
            case "europe_helsinki" -> { return ZoneID.EUROPE_HELSINKI; }
            case "europe_isle_of_man" -> { return ZoneID.EUROPE_ISLE_OF_MAN; }
            case "europe_istanbul" -> { return ZoneID.EUROPE_ISTANBUL; }
            case "europe_jersey" -> { return ZoneID.EUROPE_JERSEY; }
            case "europe_kaliningrad" -> { return ZoneID.EUROPE_KALININGRAD; }
            case "europe_kiev" -> { return ZoneID.EUROPE_KIEV; }
            case "europe_kirov" -> { return ZoneID.EUROPE_KIROV; }
            case "europe_kyiv" -> { return ZoneID.EUROPE_KYIV; }
            case "europe_lisbon" -> { return ZoneID.EUROPE_LISBON; }
            case "europe_ljubljana" -> { return ZoneID.EUROPE_LJUBLJANA; }
            case "europe_london" -> { return ZoneID.EUROPE_LONDON; }
            case "europe_luxembourg" -> { return ZoneID.EUROPE_LUXEMBOURG; }
            case "europe_madrid" -> { return ZoneID.EUROPE_MADRID; }
            case "europe_malta" -> { return ZoneID.EUROPE_MALTA; }
            case "europe_mariehamn" -> { return ZoneID.EUROPE_MARIEHAMN; }
            case "europe_minsk" -> { return ZoneID.EUROPE_MINSK; }
            case "europe_monaco" -> { return ZoneID.EUROPE_MONACO; }
            case "europe_moscow" -> { return ZoneID.EUROPE_MOSCOW; }
            case "europe_nicosia" -> { return ZoneID.EUROPE_NICOSIA; }
            case "europe_oslo" -> { return ZoneID.EUROPE_OSLO; }
            case "europe_paris" -> { return ZoneID.EUROPE_PARIS; }
            case "europe_podgorica" -> { return ZoneID.EUROPE_PODGORICA; }
            case "europe_prague" -> { return ZoneID.EUROPE_PRAGUE; }
            case "europe_riga" -> { return ZoneID.EUROPE_RIGA; }
            case "europe_rome" -> { return ZoneID.EUROPE_ROME; }
            case "europe_samara" -> { return ZoneID.EUROPE_SAMARA; }
            case "europe_san_marino" -> { return ZoneID.EUROPE_SAN_MARINO; }
            case "europe_sarajevo" -> { return ZoneID.EUROPE_SARAJEVO; }
            case "europe_saratov" -> { return ZoneID.EUROPE_SARATOV; }
            case "europe_simferopol" -> { return ZoneID.EUROPE_SIMFEROPOL; }
            case "europe_skopje" -> { return ZoneID.EUROPE_SKOPJE; }
            case "europe_sofia" -> { return ZoneID.EUROPE_SOFIA; }
            case "europe_stockholm" -> { return ZoneID.EUROPE_STOCKHOLM; }
            case "europe_tallinn" -> { return ZoneID.EUROPE_TALLINN; }
            case "europe_tirane" -> { return ZoneID.EUROPE_TIRANE; }
            case "europe_tiraspol" -> { return ZoneID.EUROPE_TIRASPOL; }
            case "europe_ulyanovsk" -> { return ZoneID.EUROPE_ULYANOVSK; }
            case "europe_uzhgorod" -> { return ZoneID.EUROPE_UZHGOROD; }
            case "europe_vaduz" -> { return ZoneID.EUROPE_VADUZ; }
            case "europe_vatican" -> { return ZoneID.EUROPE_VATICAN; }
            case "europe_vienna" -> { return ZoneID.EUROPE_VIENNA; }
            case "europe_vilnius" -> { return ZoneID.EUROPE_VILNIUS; }
            case "europe_volgograd" -> { return ZoneID.EUROPE_VOLGOGRAD; }
            case "europe_warsaw" -> { return ZoneID.EUROPE_WARSAW; }
            case "europe_zagreb" -> { return ZoneID.EUROPE_ZAGREB; }
            case "europe_zaporozhye" -> { return ZoneID.EUROPE_ZAPOROZHYE; }
            case "europe_zurich" -> { return ZoneID.EUROPE_ZURICH; }
            case "gb" -> { return ZoneID.GB; }
            case "gb-eire" -> { return ZoneID.GB_EIRE; }
            case "gmt" -> { return ZoneID.GMT; }
            case "gmt0"-> { return ZoneID.GMT0; }
            case "greenwich" -> { return ZoneID.GREENWICH; }
            case "hongkong" -> { return ZoneID.HONGKONG; }
            case "iceland" -> { return ZoneID.ICELAND; }
            case "indian_antananarivo" -> { return ZoneID.INDIAN_ANTANANARIVO; }
            case "indian_chagos" -> { return ZoneID.INDIAN_CHAGOS; }
            case "indian_christmas" -> { return ZoneID.INDIAN_CHRISTMAS; }
            case "indian_cocos" -> { return ZoneID.INDIAN_COCOS; }
            case "indian_comoro" -> { return ZoneID.INDIAN_COMORO; }
            case "indian_kerguelen" -> { return ZoneID.INDIAN_KERGUELEN; }
            case "indian_mahe" -> { return ZoneID.INDIAN_MAHE; }
            case "indian_maldives" -> { return ZoneID.INDIAN_MALDIVES; }
            case "indian_mauritius" -> { return ZoneID.INDIAN_MAURITIUS; }
            case "indian_mayotte" -> { return ZoneID.INDIAN_MAYOTTE; }
            case "indian_reunion" -> { return ZoneID.INDIAN_REUNION; }
            case "iran" -> { return ZoneID.IRAN; }
            case "israel" -> { return ZoneID.ISRAEL; }
            case "jamaica" -> { return ZoneID.JAMAICA; }
            case "japan" -> { return ZoneID.JAPAN; }
            case "kwajalein" -> { return ZoneID.KWAJALEIN; }
            case "libya" -> { return ZoneID.LIBYA; }
            case "met" -> { return ZoneID.MET; }
            case "mst7mdt"-> { return ZoneID.MST7MDT; }
            case "mexico_bajanorte" -> { return ZoneID.MEXICO_BAJANORTE; }
            case "mexico_bajasur" -> { return ZoneID.MEXICO_BAJASUR; }
            case "mexico_general" -> { return ZoneID.MEXICO_GENERAL; }
            case "nz" -> { return ZoneID.NZ; }
            case "nz-chat" -> { return ZoneID.NZ_CHAT; }
            case "navajo" -> { return ZoneID.NAVAJO; }
            case "prc" -> { return ZoneID.PRC; }
            case "pst8pdt"-> { return ZoneID.PST8PDT; }
            case "pacific_apia" -> { return ZoneID.PACIFIC_APIA; }
            case "pacific_auckland" -> { return ZoneID.PACIFIC_AUCKLAND; }
            case "pacific_bougainville" -> { return ZoneID.PACIFIC_BOUGAINVILLE; }
            case "pacific_chatham" -> { return ZoneID.PACIFIC_CHATHAM; }
            case "pacific_chuuk" -> { return ZoneID.PACIFIC_CHUUK; }
            case "pacific_easter" -> { return ZoneID.PACIFIC_EASTER; }
            case "pacific_efate" -> { return ZoneID.PACIFIC_EFATE; }
            case "pacific_enderbury" -> { return ZoneID.PACIFIC_ENDERBURY; }
            case "pacific_fakaofo" -> { return ZoneID.PACIFIC_FAKAOFO; }
            case "pacific_fiji" -> { return ZoneID.PACIFIC_FIJI; }
            case "pacific_funafuti" -> { return ZoneID.PACIFIC_FUNAFUTI; }
            case "pacific_galapagos" -> { return ZoneID.PACIFIC_GALAPAGOS; }
            case "pacific_gambier" -> { return ZoneID.PACIFIC_GAMBIER; }
            case "pacific_guadalcanal" -> { return ZoneID.PACIFIC_GUADALCANAL; }
            case "pacific_guam" -> { return ZoneID.PACIFIC_GUAM; }
            case "pacific_honolulu" -> { return ZoneID.PACIFIC_HONOLULU; }
            case "pacific_johnston" -> { return ZoneID.PACIFIC_JOHNSTON; }
            case "pacific_kanton" -> { return ZoneID.PACIFIC_KANTON; }
            case "pacific_kiritimati" -> { return ZoneID.PACIFIC_KIRITIMATI; }
            case "pacific_kosrae" -> { return ZoneID.PACIFIC_KOSRAE; }
            case "pacific_kwajalein" -> { return ZoneID.PACIFIC_KWAJALEIN; }
            case "pacific_majuro" -> { return ZoneID.PACIFIC_MAJURO; }
            case "pacific_marquesas" -> { return ZoneID.PACIFIC_MARQUESAS; }
            case "pacific_midway" -> { return ZoneID.PACIFIC_MIDWAY; }
            case "pacific_nauru" -> { return ZoneID.PACIFIC_NAURU; }
            case "pacific_niue" -> { return ZoneID.PACIFIC_NIUE; }
            case "pacific_norfolk" -> { return ZoneID.PACIFIC_NORFOLK; }
            case "pacific_noumea" -> { return ZoneID.PACIFIC_NOUMEA; }
            case "pacific_pago_pago" -> { return ZoneID.PACIFIC_PAGO_PAGO; }
            case "pacific_palau" -> { return ZoneID.PACIFIC_PALAU; }
            case "pacific_pitcairn" -> { return ZoneID.PACIFIC_PITCAIRN; }
            case "pacific_pohnpei" -> { return ZoneID.PACIFIC_POHNPEI; }
            case "pacific_ponape" -> { return ZoneID.PACIFIC_PONAPE; }
            case "pacific_port_moresby" -> { return ZoneID.PACIFIC_PORT_MORESBY; }
            case "pacific_rarotonga" -> { return ZoneID.PACIFIC_RAROTONGA; }
            case "pacific_saipan" -> { return ZoneID.PACIFIC_SAIPAN; }
            case "pacific_samoa" -> { return ZoneID.PACIFIC_SAMOA; }
            case "pacific_tahiti" -> { return ZoneID.PACIFIC_TAHITI; }
            case "pacific_tarawa" -> { return ZoneID.PACIFIC_TARAWA; }
            case "pacific_tongatapu" -> { return ZoneID.PACIFIC_TONGATAPU; }
            case "pacific_truk" -> { return ZoneID.PACIFIC_TRUK; }
            case "pacific_wake" -> { return ZoneID.PACIFIC_WAKE; }
            case "pacific_wallis" -> { return ZoneID.PACIFIC_WALLIS; }
            case "pacific_yap" -> { return ZoneID.PACIFIC_YAP; }
            case "poland" -> { return ZoneID.POLAND; }
            case "portugal" -> { return ZoneID.PORTUGAL; }
            case "rok" -> { return ZoneID.ROK; }
            case "singapore" -> { return ZoneID.SINGAPORE; }
            case "systemv_ast4"-> { return ZoneID.SYSTEMV_AST4; }
            case "systemv_ast4adt"-> { return ZoneID.SYSTEMV_AST4ADT; }
            case "systemv_cst6"-> { return ZoneID.SYSTEMV_CST6; }
            case "systemv_cst6cdt"-> { return ZoneID.SYSTEMV_CST6CDT; }
            case "systemv_est5"-> { return ZoneID.SYSTEMV_EST5; }
            case "systemv_est5edt"-> { return ZoneID.SYSTEMV_EST5EDT; }
            case "systemv_hst10"-> { return ZoneID.SYSTEMV_HST10; }
            case "systemv_mst7"-> { return ZoneID.SYSTEMV_MST7; }
            case "systemv_mst7mdt"-> { return ZoneID.SYSTEMV_MST7MDT; }
            case "systemv_pst8"-> { return ZoneID.SYSTEMV_PST8; }
            case "systemv_pst8pdt"-> { return ZoneID.SYSTEMV_PST8PDT; }
            case "systemv_yst9"-> { return ZoneID.SYSTEMV_YST9; }
            case "systemv_yst9ydt"-> { return ZoneID.SYSTEMV_YST9YDT; }
            case "turkey" -> { return ZoneID.TURKEY; }
            case "uct" -> { return ZoneID.UCT; }
            case "us_alaska" -> { return ZoneID.US_ALASKA; }
            case "us_aleutian" -> { return ZoneID.US_ALEUTIAN; }
            case "us_arizona" -> { return ZoneID.US_ARIZONA; }
            case "us_central" -> { return ZoneID.US_CENTRAL; }
            case "us_east-indiana" -> { return ZoneID.US_EAST_INDIANA; }
            case "us_eastern" -> { return ZoneID.US_EASTERN; }
            case "us_hawaii" -> { return ZoneID.US_HAWAII; }
            case "us_indiana-starke" -> { return ZoneID.US_INDIANA_STARKE; }
            case "us_michigan" -> { return ZoneID.US_MICHIGAN; }
            case "us_mountain" -> { return ZoneID.US_MOUNTAIN; }
            case "us_pacific" -> { return ZoneID.US_PACIFIC; }
            case "us_samoa" -> { return ZoneID.US_SAMOA; }
            case "utc" -> { return ZoneID.UTC; }
            case "universal" -> { return ZoneID.UNIVERSAL; }
            case "w-su" -> { return ZoneID.W_SU; }
            case "wet" -> { return ZoneID.WET; }
            case "zulu" -> { return ZoneID.ZULU; }
            default           -> {
                try {
                    ZoneId           zoneId    = ZoneId.of(text);
                    Optional<ZoneID> optZoneID = Arrays.stream(values()).filter(id -> id.uiString.equals(zoneId.getId())).findFirst();
                    return optZoneID.isPresent() ? optZoneID.get() : ZoneID.NOT_FOUND;
                } catch (DateTimeException e) {
                    return ZoneID.NOT_FOUND;
                }
            }
        }
    }

    public final ZoneId getZoneId() { return uiString.isEmpty() ? ZoneId.systemDefault() : ZoneId.of(uiString); }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("offset").append(QUOTES).append(COLON).append(QUOTES).append(offset).append(QUOTES)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
