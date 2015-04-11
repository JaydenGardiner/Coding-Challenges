#Coding challenge for Eventbrite
#By Jayden Gardiner

# -----------------------------------------------
# This project should be completed using the
# Python programming language.
#
# Problem:
#----------
# Please parse the following URL into parts:
#     http://www.vandyhacks.org/dostuff/now
#
# While you've been given a specific URL
# Your solution should work for any valid
# URL.  Below is a skeleton and some test
# code.  You're job is to fill in the
# implmentation of the parse_url() function.
#
# parse_url() should return a python
# dictionary with the following keys
#
#    * protocol
#    * host
#    * uri
#
# NOTE: there are a number of solutions to
# this problem including pre-built modules
# like urlparse.
#
# Your solution should display your ability
# to create efficient readable code that
# solves the problem without using pre-built
# libraries directly related to parsing URLs
#
# If you provide multiple ways to solve the
# problem that isn't a bad thing.
# -----------------------------------------------
the_url = "http://www.vandyhacks.org/dostuff/now"

def parse_url(url):
    # This funtion takes in a URL and parses it to a protocol, host, and uri.
    dict = {};
    # Split the string 3 times based on occurrences of "/".
    splitStr = url.split("/", 3);
    # The protocol, for example "http" is the first 4 characters of the URL.
    dict['protocol'] = splitStr[0][0:4];
    # The host, for example "www.vandyhacks.org", is what's after http://
    # but before the next slash.
    dict['host'] = splitStr[2];
    # The uri, for example "dostuff/now" is the part of the URL after the host.
    dict['uri'] = splitStr[3];
    # Return a dictionary containing the URL's protocol, host, and uri.
    return dict;











# -----------------------------------------------
#  TEST CODE AND MAIN
# -----------------------------------------------
def test_parse_url(url_dict):
    if type(url_dict) != dict:
        print "FAIL: you need to return a Dictionary from parse_url()"
        return

    the_keys = url_dict.keys()
    if not 'protocol' in the_keys:
        print "FAIL: your dictionary is missing the key 'protocol'"
        return

    if not 'host' in the_keys:
        print "FAIL: your dictionary is missing the key 'host'"
        return

    if not 'uri' in the_keys:
        print "FAIL: your dictionary is missing the key 'uri'"
        return

    if url_dict.get('protocol') != "http":
        print "FAIL: key: 'protocol' should be 'http'"
        return

    if url_dict.get('host') != "www.vandyhacks.org":
        print "FAIL: key: 'host' should be 'www.vandyhacks.org'"
        return

    if url_dict.get('uri') != "dostuff/now":
        print "FAIL: key: 'uri' should be 'dostuff/now'"
        return

    print "WELL DONE YOU PASSED -- !!"


parsed_url = parse_url(the_url)
test_parse_url(parsed_url)
        