public class Api {

    public static void main(String[] args) {
        try {
            String output;
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "https://api.apinizer.com/apigateway/metin/srv1/pet/findByStatus?status=sold");
            getRequest.addHeader("Authorization", "Basic bWV0aW46bWV0aW4xMjM=");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

