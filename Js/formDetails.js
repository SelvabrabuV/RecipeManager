var app=angular.module('MyApp',['ngRoute']);

app.controller('mycontrol',function($scope,$http){
	$scope.names=[{id:0,name:"recipie1"},{id:1,name:"recipie2"},{id:2,name:"recipie3"}];
	
	$scope.GetValue = function (names) {
		
                var nameId = $scope.capture;
      
		

        $http.get("/getdetails?name="+nameId)
.success(function (data, status, headers, config) {
                $scope.recpname = nameId;
				$scope.value1 = data.value1;
				$scope.value2 = data.value2;
				$scope.value3 = data.value3;
				$scope.value4 = data.value4;
            }).
            error(function (data, status, headers, config) {
                alert("An error occurred during the request");
            });
	
};
                
	
	
	});
	
app.config(['$routeProvider', function($routeProvider){
   $routeProvider.
    when('/form', {
	  
      templateUrl: 'form.html',
	  controller: 'addreceipe'
   }).
   
   when('/details', {
      templateUrl: 'details.html',
	  controller: 'mycontrol'
   }).
   otherwise({
        templateUrl: 'welcome.html'
      });
	  }]);
app.controller('recipedetails',function($scope){
$scope.recpname = "Butter Milk";
$scope.value1 = "Sugar";
$scope.value2 = "Green Leaves";
$scope.value3 = "curd";
$scope.value4 = "Water";
});

app.controller('addreceipe',function($scope,$http){
	$scope.submitfunc = function () {
		

        $http.post("/updatedetails?name="+$scope.firstname+"Ingredient1="+$scope.Ingredient1)
.success(function (data, status, headers, config) {
                alert('Your full name is - ' + data.fullName);
            }).
            error(function (data, status, headers, config) {
                alert("An error occurred during the request");
            });
	
};



});


		
		



	