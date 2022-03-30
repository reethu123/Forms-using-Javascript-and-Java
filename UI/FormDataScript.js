          const urlPerfix = "http://localhost:8010/api/v1/";


          $(document).ready(function() {
          
        
            if ("name" in sessionStorage) {
               document.getElementById("name").value = sessionStorage.getItem('name');
            }

            if ("sectors" in sessionStorage) {
                document.getElementById("sectors").value = sessionStorage.getItem('sectors');  
            }

            if ("agreeToTerms" in sessionStorage) {
                document.getElementById("agreeToTerms").value = sessionStorage.getItem('agreeToTerms');  
            }

            if ("id" in sessionStorage) {
                document.getElementById("addForm").action = urlPerfix + "formData/"+sessionStorage.getItem('id');
            }
          
          });
         const http = new XMLHttpRequest();

          http.open("GET", urlPerfix + "sectorTypes");
          http.send();

          http.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var sectorResponse = this.responseText;
                document.getElementById("sectors").innerHTML = sectorResponse;            
            }
          };


          function addSectorReturn(){
            // location.reload();
            alert('Sector added succesfully'); 
          }


          $(function(){
          $('form[name=addForm]').submit(function(){
            $.post($(this).attr('action'), $(this).serialize(), function(json) {
              sessionStorage.setItem('name',json['name']);
              sessionStorage.setItem('id',json['id']);
              sessionStorage.setItem('sectors',json['sectors']);
              sessionStorage.setItem('agreeToTerms',json['agreeToTerms']);
              
              document.getElementById("name").value = json['name'];
              document.getElementById("sectors").value = json['sectors'];
              document.getElementById("agreeToTerms").value = json['agreeToTerms'];
              document.getElementById("addForm").action = urlPerfix + "formData/"+json['id'];
            }, 'json');
            return false;
          });
        });

          

