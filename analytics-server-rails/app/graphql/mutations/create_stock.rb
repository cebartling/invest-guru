class Mutations::CreateStock < Mutations::BaseMutation
  null true

  argument :symbol, String, required: true
  argument :company_name, String, required: true

  field :stock, Types::StockType, null: true
  field :errors, [String], null: false

  def resolve(symbol:, company_name:)
    stock = Stock.find_by_symbol symbol
    unless stock
      stock = Stock.new(symbol: symbol, company_name: company_name)
      if stock.save
        # Successful creation, return the created object with no errors
        {stock: stock, errors: []}
      else
        # Failed save, return the errors to the client
        {stock: nil, errors: stock.errors.full_messages}
      end
    end
  end
end
