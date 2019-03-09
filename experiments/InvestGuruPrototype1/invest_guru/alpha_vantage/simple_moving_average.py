import os

import requests


# {
#     "Meta Data": {
#         "1: Symbol": "MSFT",
#         "2: Indicator": "Simple Moving Average (SMA)",
#         "3: Last Refreshed": "2019-03-04",
#         "4: Interval": "daily",
#         "5: Time Period": 50,
#         "6: Series Type": "open",
#         "7: Time Zone": "US/Eastern"
#     },
#     "Technical Analysis: SMA": {
#         "2019-03-04": {
#             "SMA": "105.1082"
#         },
#         "2019-03-01": {
#             "SMA": "104.9228"
#         },
#         "2019-02-28": {
#             "SMA": "104.7732"
#         },
#         "2019-02-27": {
#             "SMA": "104.6974"
#         },
#         "2019-02-26": {
#             "SMA": "104.6552"
#         },
#         "2019-02-25": {
#             "SMA": "104.6478"
#         },
#         "2019-02-22": {
#             "SMA": "104.6086"
#         },
#         "2019-02-21": {
#             "SMA": "104.5036"
#         },
#         "2019-02-20": {
#             "SMA": "104.5332"
#         },
#         "2019-02-19": {
#             "SMA": "104.4924"
#         },
#         "2019-02-15": {
#             "SMA": "104.5754"
#         },
#         "2019-02-14": {
#             "SMA": "104.6772"
#         },
#         "2019-02-13": {
#             "SMA": "104.7650"
#         },
#         "2019-02-12": {
#             "SMA": "104.8216"
#         },
#         "2019-02-11": {
#             "SMA": "104.8566"
#         },
#         "2019-02-08": {
#             "SMA": "104.8580"
#         }
#     }
# }

TECHNICAL_ANALYSIS_SMA_KEY = "Technical Analysis: SMA"
SMA_KEY = 'SMA'


def simple_moving_average(symbol, time_period=50):
    function_param = "function=SMA"
    symbol_param = "symbol={}".format(symbol)
    interval_param = "interval=daily"
    time_period_param = "time_period={}".format(time_period)
    series_type_param = "series_type=close"
    alpha_vantage_api_key = os.environ['alphaVantageApiKey']
    api_key_param = "apikey={}".format(alpha_vantage_api_key)
    api_url = "https://www.alphavantage.co/query?{}&{}&{}&{}&{}&{}".format(function_param,
                                                                           symbol_param,
                                                                           interval_param,
                                                                           time_period_param,
                                                                           series_type_param,
                                                                           api_key_param)
    result = dict()
    response = requests.get(api_url)
    if response.status_code == requests.codes.ok:
        result = response.json()
        if TECHNICAL_ANALYSIS_SMA_KEY in result:
            sma_dict = result[TECHNICAL_ANALYSIS_SMA_KEY]
            for key in sorted(sma_dict):
                sma_value = sma_dict[key][SMA_KEY]
                result[key] = sma_value

    return result

