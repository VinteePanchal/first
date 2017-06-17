'use strict';

angular.module('sortApp').factory('SortService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            	loadList: loadList,
                getAllList: getAllList
            };

            return factory;

            function loadList() {
                console.log('Fetching list');
                var deferred = $q.defer();
                $http.get(urls.SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully');
                            $localStorage.sortList = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading data');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllList(){
                return $localStorage.sortList;
            }
           
        }
    ]);