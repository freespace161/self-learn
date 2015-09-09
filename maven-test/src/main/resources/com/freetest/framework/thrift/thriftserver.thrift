############
#test server
#####
namespace java com.freetest.framework.thrift


service TestService{
  
  string doRequest( 1:required string req ) 
}