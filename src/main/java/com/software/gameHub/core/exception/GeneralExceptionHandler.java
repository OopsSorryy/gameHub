package com.software.gameHub.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatus status,
                                                                  @NonNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CategoryIdDoesNotExistException.class)
    public ResponseEntity<?> categoryIdDoesNotExistExceptionHandler(CategoryIdDoesNotExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CommentIdDoesNotExistException.class)
    public ResponseEntity<?> commentIdDoesNotExistExceptionHandler(CommentIdDoesNotExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerIdDoesNotExistException.class)
    public ResponseEntity<?> customerIdDoesNotExistExceptionHandler(CustomerIdDoesNotExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> customerNotFoundExceptionHandler(CustomerNotFoundException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GameIdDoesNotExistException.class)
    public ResponseEntity<?> gameIdDoesNotExistExceptionHandler(GameIdDoesNotExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(WalletIdDoesNotExistException.class)
    public ResponseEntity<?> walletIdDoesNotExistExceptionHandler(WalletIdDoesNotExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<?> imageNotFoundExceptionHandler(ImageNotFoundException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryNameAlreadyExistsException.class)
    public ResponseEntity<?> categoryNameAlreadyExistsExceptionHandler(CategoryNameAlreadyExistsException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(GameAlreadyExistsInBasketException.class)
    public ResponseEntity<?> gameAlreadyExistsInBasketExceptionHandler(GameAlreadyExistsInBasketException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(GameAlreadyExistInLibrary.class)
    public ResponseEntity<?> gameAlreadyExistInLibraryExceptionHandler(GameAlreadyExistInLibrary exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MaxImageException.class)
    public ResponseEntity<?> maxImageExceptionHandler(MaxImageException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<?>tokenNotValidExceptionHandler(TokenNotValidException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
