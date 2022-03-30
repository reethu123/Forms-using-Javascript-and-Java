 		const urlPerfix = "http://localhost:8010/api/v1/";


 		const http = new XMLHttpRequest();

	    http.open("GET", urlPerfix + "sectors");
	    http.send();

	    http.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		        var sectorResponse = this.responseText;
		        document.getElementById("sectorList").innerHTML = sectorResponse;            
		    }
	    };


	    function getAddSectorTypeMenu() {
	    	const http1 = new XMLHttpRequest();
  			http1.open("GET", urlPerfix + "sectorTypes/menu");
	    	http1.send();

	    	http1.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			        var sectorResponse = this.responseText;
			        document.getElementById("typeAdd").innerHTML = sectorResponse;            
			    }
	    	};

	        document.getElementById("addForm").action = urlPerfix + "sectors";            

		}

		function getEditSectorTypeMenu(id) {
	    	const http1 = new XMLHttpRequest();
  			http1.open("GET", urlPerfix + "sectorTypes/menu");
	    	http1.send();

	    	http1.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			        var sectorResponse = this.responseText;
			        document.getElementById("typeEdit").innerHTML = sectorResponse;            
			    }
	    	};


	    	const http2 = new XMLHttpRequest();
  			http2.open("GET", urlPerfix + "sectors/"+id);
	    	http2.send();

	    	http2.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			        var sectorResponse = this.responseText;
			        var jsonParsedArray = JSON.parse(sectorResponse);
					  	
					document.getElementById("name").value = jsonParsedArray['name'];
					document.getElementById("typeEdit").value = jsonParsedArray['type'];  
					document.getElementById("editForm").action = urlPerfix + "sectors/update/"+id;
			    }
	    	};
		}

		function addSectorReturn(){
			alert('Saved succesfully'); 
            location.reload();
		}


		function deleteSectorReturn(){
            location.reload();
            alert('Sector deleted succesfully'); 
		}


   		function deleteLinkFunction(id) {
   			const httpdelete = new XMLHttpRequest();

		    httpdelete.open("DELETE", urlPerfix + "sectors/"+id);
		    httpdelete.send();

		    httpdelete.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			        location.reload();
	            	alert('Sector deleted succesfully');            
			    }
		    };

   		}