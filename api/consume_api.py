import requests  
# if the requestes is not downloaded do, pip3 install requests
import json

# make a request to the web page , 
# requests.get('https://api.stackexchange.com/2.3/questions?order=desc&sort=activity&site=stackoverflow')

## request gonna return a response 
response = requests.get('https://api.stackexchange.com/2.3/questions?order=desc&sort=activity&site=stackoverflow')

for data in response.json()['items']:
    print(data['title'])
    print(data['link'])
    print()


# response .json() --> gives all the json data 