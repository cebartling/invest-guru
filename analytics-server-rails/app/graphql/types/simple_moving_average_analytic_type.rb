module Types
  class SimpleMovingAverageAnalyticType < Types::BaseObject
    description 'A simple moving average (SMA) is an arithmetic moving average calculated by adding recent closing prices and then dividing that by the number of time periods in the calculation average.'
    #field :id, ID, null: false
    field :stock, Stock, null: false
    field :days, Integer, null: false
  end
end
