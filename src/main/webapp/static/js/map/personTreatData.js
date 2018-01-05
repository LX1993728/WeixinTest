var personTreatData = {

    //医院
    getHospitalData : function getHospitalData(){
 		var map = {};
 		//
 		var CSJZData = [
 		{ 
 		  'id':'CSJZ1',
 		  'image':'../img/危险源/web/事故.png',
 		  'text':'南山区蛇口人民医院',
 		  'lonlat':[],
      'name':'李',
      'tel':'13812341243',
      'parentId':'CSJZ',
      'parentName':'创伤医院救治'


 		},
 		{
 		  'id':'CSJZ2',
      'image':'../img/危险源/web/事故.png',
      'text':'深圳市第六人民医院',
      'lonlat':[],
      'name':'李',
      'tel':'13812341243',
      'parentId':'CSJZ',
      'parentName':'创伤医院救治'
 		},
 		];
        //
 		var SSJZData =[
 		{
 		  'id':'CSJZ2',
      'image':'../img/危险源/web/事故.png',
      'text':'深圳市第二人民医院',
      'lonlat':[],
      'name':'李',
      'tel':'13812341243',
      'parentId':'CSJZ',
      'parentName':'烧伤医院救治'

 		},
 		];

    map['CSJZData'] = CSJZData;
    map['SSJZData'] = SSJZData;
       
        return map;
    },
    
    
   
    
    //房屋统计
    getHouseData : function getHouseData(){
 		var map = {};
 		//场所
 		var place = 
 		[
 		{ 
 		  'id':'place',
 		  'image':'../img/web/场所.png',
 		  'text':'place1',
 		  'lonlat':[113.9828,22.684842],
 		  'personNum':20,
 		  'tel':"0755-23123454"


 		},
 		{
 		  'id':'place',
 		  'image':'../img/web/场所.png',
 		  'text':'place2',
 		  'lonlat':[114.118755,22.602593],
 		  'personNum':30,
 		  'tel':"0755-23123454"
 		},
 		];
        //法人单位
 		var company =
        [
 		{
 		  'id':'company',
 		  'image':'../img/web/法人办事.png',
 		  'text':'company1',
 		  'lonlat':[114.050091,22.644424],
 		  'personNum':300,
 		  'tel':"0755-23123454"

 		},
 		];
 		//船舶
 		var boat =
        [
 		{
 		  'id':'boat',
 		  'image':'../img/web/船.png',
 		  'text':'boat1',
 		  'lonlat':[114.153491,22.647424],
 		  'personNum':200,
 		  'tel':"0755-23123454"

 		},
 		{
 		  'id':'boat',
 		  'image':'../img/web/船.png',
 		  'text':'boat2',
 		  'lonlat':[114.153491,22.747424],
 		  'personNum':278,
 		  'tel':"0755-23123454"

 		},
 		];
        map['place'] = place;
        map['company'] = company;
        map['boat'] = boat;
        return map;
    },
    


}
